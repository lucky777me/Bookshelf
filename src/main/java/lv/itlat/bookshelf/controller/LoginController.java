package lv.itlat.bookshelf.controller;


import lv.itlat.bookshelf.persistence.domain.User;
import lv.itlat.bookshelf.persistence.repository.UserRepository;
import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@RequestScoped
@Named
public class LoginController {
    private Logger logger = Logger.getLogger(LoginController.class);
    @Inject
    private CurrentUser currentUser;
    @Inject
    private UserRepository userRepository;
    @NotBlank(message = "Login must not be blank")
    private String loginName;
    @NotBlank(message = "Password must not be blank")
    private String password;

    public String login() {
        Optional<User> foundedUser = userRepository.findByLoginName(loginName);
        User user;
        if (!foundedUser.isPresent()) {
            FacesMessage msg = new FacesMessage("Please register new user.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }
        user = foundedUser.get();
        if (!password.equals(user.getPasswordHash())) {
            FacesMessage msg = new FacesMessage("Password or login name is incorrect.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            currentUser.setUser(user);
            return "index.xhtml";
        }
        return null;
    }

    public String logout() {
        logger.info("Logging out");
        currentUser.setUser(null);
        return "goodbye.xhtml";
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
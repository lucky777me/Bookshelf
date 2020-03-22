package lv.itlat.bookshelf.controller;


import lv.itlat.bookshelf.persistence.domain.User;
import lv.itlat.bookshelf.persistence.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Objects;

@Named
@RequestScoped
public class RegistrationController implements Serializable {


    private String password1;
    private String password2;
    private User user = new User();

    @Inject
    private UserRepository userRepository;

    public String register() {
        if (!Objects.equals(password1, password2)) {
            FacesMessage msg = new FacesMessage("Passwords do not match");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        user.setPasswordHash(password1);
        userRepository.create(user);
        user = new User();
        return "login.xhtml";
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
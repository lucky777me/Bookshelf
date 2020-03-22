package lv.itlat.bookshelf.persistence.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity(name="User")
@Table(name="USER")
public class User implements Serializable {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Login must not be empty")
    @Size(min = 4,message ="Login name must be at least 4 characters long")
    @Size(max = 100,message ="Login name is too long")
    @Column(name="LOGIN_NAME" ,length= 100, unique = true, nullable = false)
    private String loginName;

    @Column(name="PASSWORD_HASH",nullable = false)
    private String passwordHash;

    @NotBlank(message ="First Name can not be empty")
    @Column(name="FIRST_NAME",nullable = false)
    private String firstName;

    @NotBlank(message = "Last Name can not be empty")
    @Column(name = "LAST_NAME",nullable = false)
    private String lastName;

    @NotBlank(message = "Email is mandatory field")
    @Email(message = "Please enter a correct email address.")
    @Column
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

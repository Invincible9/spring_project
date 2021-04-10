package bg.example.football.model.service;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

public class UserRegisterServiceModel {

    @Email(message = "Enter valid email!")
    private String email;

    @Length(min = 3, message = "Full Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String fullName;

    @Length(min = 3, message = "Password length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String password;

    public UserRegisterServiceModel() {
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterServiceModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}

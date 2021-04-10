package bg.example.football.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

public class UserRegisterBindingModel {

    @Email(message = "Enter valid email!")
    private String email;

    @Length(min = 3, message = "Full Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String fullName;

    @Length(min = 3, message = "Password length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String password;

    @Length(min = 3, message = "Confirm Password length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

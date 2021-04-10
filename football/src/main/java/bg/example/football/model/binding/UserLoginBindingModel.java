package bg.example.football.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

public class UserLoginBindingModel {

    @Email(message = "Enter valid email!")
    private String email;

    @Length(min = 3, message = "Password length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String password;

    public UserLoginBindingModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

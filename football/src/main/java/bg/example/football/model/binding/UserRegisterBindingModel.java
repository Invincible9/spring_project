package bg.example.football.model.binding;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserRegisterBindingModel {

    @NotNull
    private String email;

    @NotNull
    private String fullName;

    @Min(value = 3)
    private String password;

    @Min(value = 3)
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

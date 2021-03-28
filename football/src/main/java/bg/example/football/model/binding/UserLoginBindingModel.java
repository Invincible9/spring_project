package bg.example.football.model.binding;

import javax.validation.constraints.NotNull;

public class UserLoginBindingModel {
    @NotNull
    private String email;

    @NotNull
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
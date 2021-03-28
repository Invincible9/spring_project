package bg.example.football.model.service;

import javax.validation.constraints.NotNull;

public class UserLoginServiceModel {

    @NotNull
    private String email;
    @NotNull
    private String password;

    public UserLoginServiceModel() {
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

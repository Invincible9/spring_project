package bg.example.football.model.service;

import javax.validation.constraints.NotNull;

public class UserRegisterServiceModel {
    @NotNull
    private String email;

    @NotNull
    private String fullName;

    @NotNull
    private String password;

    public UserRegisterServiceModel() {
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
}

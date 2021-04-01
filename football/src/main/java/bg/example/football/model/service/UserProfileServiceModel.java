package bg.example.football.model.service;

import org.springframework.web.multipart.MultipartFile;

public class UserProfileServiceModel {

    private String email;
    private String fullName;
    private MultipartFile image;

    public UserProfileServiceModel() {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}

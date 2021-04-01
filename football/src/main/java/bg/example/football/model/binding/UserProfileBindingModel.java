package bg.example.football.model.binding;


import org.springframework.web.multipart.MultipartFile;

public class UserProfileBindingModel {

    private String email;
    private String fullName;
    private MultipartFile image;

    public UserProfileBindingModel() {
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

package bg.example.football.model.binding;

import bg.example.football.config.validation.ValidImage;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

public class NationalityBindingModel {

    @Length(min = 3, message = "Full Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String name;

    @ValidImage
    private MultipartFile logo;

    public NationalityBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getLogo() {
        return logo;
    }

    public void setLogo(MultipartFile logo) {
        this.logo = logo;
    }

}

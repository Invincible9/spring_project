package bg.example.football.model.service;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class NationalityServiceModel {

    @Length(min = 3, message = "Full Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String name;

    @NotNull
    private MultipartFile logo;

    public NationalityServiceModel() {
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

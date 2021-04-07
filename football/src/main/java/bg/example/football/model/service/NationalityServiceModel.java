package bg.example.football.model.service;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class NationalityServiceModel {
    @NotNull
    private String name;
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

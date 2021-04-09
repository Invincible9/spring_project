package bg.example.football.model.service;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class DivisionServiceModel {
    @NotNull
    private String name;
    @NotNull
    private MultipartFile logo;
    @NotNull
    private String nationalityName;

    public DivisionServiceModel() {
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

    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
    }
}

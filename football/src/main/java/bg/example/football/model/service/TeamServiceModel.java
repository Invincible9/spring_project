package bg.example.football.model.service;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class TeamServiceModel {
    @NotNull
    private String name;
    @NotNull
    private MultipartFile logo;
    @NotNull
    private String divisionName;

    public TeamServiceModel() {
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

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}

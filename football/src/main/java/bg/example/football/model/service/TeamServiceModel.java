package bg.example.football.model.service;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class TeamServiceModel {

    @Length(min = 3, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String name;

    @NotNull
    private MultipartFile logo;

    @NotNull(message = "Enter valid division name!")
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

package bg.example.football.model.binding;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class TeamBindingModel {
    @NotNull
    private String name;
    @NotNull
    private MultipartFile logo;
    @NotNull
    private String divisionName;

    public TeamBindingModel() {
    }

    public String getName() {
        return name;
    }

    public TeamBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public MultipartFile getLogo() {
        return logo;
    }

    public TeamBindingModel setLogo(MultipartFile logo) {
        this.logo = logo;
        return this;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public TeamBindingModel setDivisionName(String divisionName) {
        this.divisionName = divisionName;
        return this;
    }
}

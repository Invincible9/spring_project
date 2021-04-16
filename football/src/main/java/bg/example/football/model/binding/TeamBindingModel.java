package bg.example.football.model.binding;

import bg.example.football.config.validation.ValidImage;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

public class TeamBindingModel {

    @Length(min = 3, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String name;

    @ValidImage
    private MultipartFile logo;

    @NotEmpty(message = "Enter valid division name!")
    private String divisionId;

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

    public String getDivisionId() {
        return divisionId;
    }

    public TeamBindingModel setDivisionId(String divisionId) {
        this.divisionId = divisionId;
        return this;
    }
}

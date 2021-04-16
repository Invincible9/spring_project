package bg.example.football.model.binding;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

public class TeamEditBindingModel {
    @Length(min = 3, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String name;

    private MultipartFile logo;

    @NotEmpty(message = "Enter valid division name!")
    private String divisionId;

    private String logoUrl;

    public TeamEditBindingModel() {
    }

    public String getName() {
        return name;
    }

    public TeamEditBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public MultipartFile getLogo() {
        return logo;
    }

    public TeamEditBindingModel setLogo(MultipartFile logo) {
        this.logo = logo;
        return this;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public TeamEditBindingModel setDivisionId(String divisionId) {
        this.divisionId = divisionId;
        return this;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public TeamEditBindingModel setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }
}

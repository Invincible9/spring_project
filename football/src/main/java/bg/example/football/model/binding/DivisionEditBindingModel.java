package bg.example.football.model.binding;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

public class DivisionEditBindingModel {
    @Length(min = 3, message = "Full Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String name;

    private MultipartFile logo;

    @NotEmpty(message = "Enter valid nationality name!")
    private String nationalityName;

    private String logoUrl;

    public String getName() {
        return name;
    }

    public DivisionEditBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public MultipartFile getLogo() {
        return logo;
    }

    public DivisionEditBindingModel setLogo(MultipartFile logo) {
        this.logo = logo;
        return this;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public DivisionEditBindingModel setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
        return this;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public DivisionEditBindingModel setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }
}

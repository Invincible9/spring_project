package bg.example.football.model.binding;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

public class NationalityEditBindingModel {
    @Length(min = 3, message = "Full Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String name;

    private MultipartFile logo;

    private String logoUrl;

    public String getName() {
        return name;
    }

    public NationalityEditBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public MultipartFile getLogo() {
        return logo;
    }

    public NationalityEditBindingModel setLogo(MultipartFile logo) {
        this.logo = logo;
        return this;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public NationalityEditBindingModel setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }
}

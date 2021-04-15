package bg.example.football.model.view;

public class NationalityViewModel extends BaseViewModel {
    private String name;
    private String logoUrl;

    public NationalityViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public NationalityViewModel setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }
}

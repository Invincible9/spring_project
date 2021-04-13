package bg.example.football.model.view;

public class DivisionViewModel extends BaseViewModel{
    private String name;
    private String logoUrl;

    public DivisionViewModel() {
    }

    public String getName() {
        return name;
    }

    public DivisionViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public DivisionViewModel setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }
}

package bg.example.football.model.view;

public class TeamViewModel {
    private String name;
    private String logoUrl;
    private DivisionViewModel division;

    public TeamViewModel() {
    }

    public String getName() {
        return name;
    }

    public TeamViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public TeamViewModel setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }

    public DivisionViewModel getDivision() {
        return division;
    }

    public TeamViewModel setDivision(DivisionViewModel division) {
        this.division = division;
        return this;
    }
}

package bg.example.football.model.view;

public class DivisionViewModel extends BaseViewModel{
    private String name;
    private String logoUrl;
    private NationalityViewModel nationalityViewModel;

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

    public NationalityViewModel getNationalityViewModel() {
        return nationalityViewModel;
    }

    public DivisionViewModel setNationalityViewModel(NationalityViewModel nationalityViewModel) {
        this.nationalityViewModel = nationalityViewModel;
        return this;
    }
}

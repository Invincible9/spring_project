package bg.example.football.model.binding;

public class BaseBindingModel {
    private String id;

    public BaseBindingModel() {
    }

    public String getId() {
        return id;
    }

    public BaseBindingModel setId(String id) {
        this.id = id;
        return this;
    }
}

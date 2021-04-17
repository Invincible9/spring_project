package bg.example.football.model.binding;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class SeasonBindingModel {

    @Length(min = 3, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String name;

    @NotEmpty(message = "Enter valid division name!")
    private String divisionId;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public SeasonBindingModel() {
    }

    public String getName() {
        return name;
    }

    public SeasonBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public SeasonBindingModel setDivisionId(String divisionId) {
        this.divisionId = divisionId;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public SeasonBindingModel setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public SeasonBindingModel setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }
}

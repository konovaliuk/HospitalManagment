package hospitalManagment.dto;

import hospitalManagment.models.DiagnosisModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DiagnosisDTO {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String state;

    public DiagnosisDTO(@org.jetbrains.annotations.NotNull DiagnosisModel model) {

        this.name = model.getName();
        this.state = model.getState().toString();
    }

    public DiagnosisDTO() {

    }
}

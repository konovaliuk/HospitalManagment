package hospitalManagment.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class TreatmentDTO {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String type;

    @Getter
    @Setter
    private String state;

    public TreatmentDTO(String name, String type, String state) {
        this.name = name;
        this.type = type;
        this.state = state;
    }

    public TreatmentDTO() {

    }
}

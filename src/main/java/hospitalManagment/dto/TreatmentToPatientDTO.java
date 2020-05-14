package hospitalManagment.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class TreatmentToPatientDTO {

    @Setter
    @Getter
    @JsonIgnore
    private Long patientId;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String state;

    @Getter
    @Setter
    private String type;
}

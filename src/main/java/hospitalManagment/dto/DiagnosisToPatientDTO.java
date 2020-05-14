package hospitalManagment.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisToPatientDTO {

    @Setter
    @Getter
    @JsonIgnore
    private Long patientId;

    @Getter
    @Setter
    private String diagnosisName;

    @Getter
    @Setter
    private String diagnosisState;
}

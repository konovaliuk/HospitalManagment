package hospitalManagment.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

public class CompleteTreatmentToPatientDTO {

    @Setter
    @Getter
    @JsonIgnore
    private Long patientId;

    @Setter
    @Getter
    @JsonIgnore
    private Long treatmentId;
}

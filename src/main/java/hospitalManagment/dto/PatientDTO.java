package hospitalManagment.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PatientDTO {

    @Getter
    @JsonIgnore
    private Long id;

    @Getter
    @Setter
    private String name;

    public PatientDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PatientDTO() {

    }
}

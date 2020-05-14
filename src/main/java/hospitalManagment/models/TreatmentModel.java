package hospitalManagment.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Treatment")
@NoArgsConstructor
public class TreatmentModel {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Getter
    @Setter
    private Type type;
    State state;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private PatientModel patient;

    public enum State {
        ASSIGN, DONE
    }

    public enum Type {
        DRUG, PROCEDURE, SURGERY
    }


}

package hospitalManagment.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Diagnosis")
@NoArgsConstructor
public class DiagnosisModel {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Getter
    @Setter
    private State state;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private PatientModel patient;

    public enum State {
        PRIMARY, FINAL
    }
}
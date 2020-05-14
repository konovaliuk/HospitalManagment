package hospitalManagment.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Patients")
@RequiredArgsConstructor
public class PatientModel {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private List<DiagnosisModel> diagnosis;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private List<TreatmentModel> treatments;
}

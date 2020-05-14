package hospitalManagment.repository.iRepository;

import hospitalManagment.dto.DiagnosisToPatientDTO;
import hospitalManagment.dto.TreatmentToPatientDTO;
import hospitalManagment.models.DiagnosisModel;
import hospitalManagment.models.PatientModel;
import hospitalManagment.models.TreatmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iPatientRepository extends JpaRepository<PatientModel, Long> {

    Optional<DiagnosisModel> setDiagnosis(DiagnosisToPatientDTO diagnosisToPatient);
    Optional<TreatmentModel> setTreatment(TreatmentToPatientDTO treatmentToPatient);
}

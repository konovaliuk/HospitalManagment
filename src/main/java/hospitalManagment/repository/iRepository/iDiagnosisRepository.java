package hospitalManagment.repository.iRepository;

import hospitalManagment.models.DiagnosisModel;
import hospitalManagment.models.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iDiagnosisRepository extends JpaRepository<DiagnosisModel, Long> {

    List<DiagnosisModel> historyPatient(PatientModel patient);
}

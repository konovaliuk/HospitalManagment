package hospitalManagment.repository.iRepository;

import hospitalManagment.models.PatientModel;
import hospitalManagment.models.TreatmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iTreatmentRepository extends JpaRepository<TreatmentModel, Long> {

    List<TreatmentModel> historyPatient(PatientModel patient);
}

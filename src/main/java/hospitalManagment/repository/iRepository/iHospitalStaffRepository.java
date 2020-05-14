package hospitalManagment.repository.iRepository;

import hospitalManagment.dto.CompleteTreatmentToPatientDTO;
import hospitalManagment.dto.PatientDTO;
import hospitalManagment.models.HospitalStaffModel;
import hospitalManagment.models.PatientModel;
import hospitalManagment.models.TreatmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iHospitalStaffRepository extends JpaRepository<HospitalStaffModel, Long> {

    Optional<HospitalStaffModel> findByEmailAndPassword(String email, String password);
    Optional<TreatmentModel> completeTreatment(CompleteTreatmentToPatientDTO completeTreatmentToPatient);
    Optional<PatientModel> dischargePatient(PatientDTO patient);
}

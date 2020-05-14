package hospitalManagment.service;

import hospitalManagment.dto.CompleteTreatmentToPatientDTO;
import hospitalManagment.dto.PatientDTO;
import hospitalManagment.dto.StaffDTO;
import hospitalManagment.dto.TreatmentDTO;
import hospitalManagment.models.DiagnosisModel;
import hospitalManagment.models.HospitalStaffModel;
import hospitalManagment.models.PatientModel;
import hospitalManagment.models.TreatmentModel;
import hospitalManagment.repository.iRepository.iDiagnosisRepository;
import hospitalManagment.repository.iRepository.iHospitalStaffRepository;
import hospitalManagment.repository.iRepository.iPatientRepository;
import hospitalManagment.repository.iRepository.iTreatmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log4j2
public class StaffService {

    private final iHospitalStaffRepository staffRepository;
    private final iPatientRepository patientRepository;
    private final iTreatmentRepository treatmentRepository;
    private final iDiagnosisRepository diagnosisRepository;

    public StaffDTO authorize(String mail, String password) {

        StaffDTO userDto = new StaffDTO();
        try {
            Optional<HospitalStaffModel> staffOpt = staffRepository.findByEmailAndPassword(mail, password);
            if (staffOpt.isPresent()) {
                HospitalStaffModel staff = staffOpt.get();
                userDto.setEmail(staff.getEmail());
                userDto.setLogin(staff.getLogin());
                userDto.setPassword(staff.getPassword());
                userDto.setName(staff.getName());
                userDto.setRole(staff.getRole().toString());
            }
        } catch (Exception e) {
            log.error(e.getStackTrace());
        }

        return userDto;
    }

    public TreatmentDTO completeTreatment(CompleteTreatmentToPatientDTO completeTreatmentToPatient) {

        Optional<TreatmentModel> treatmentOpt = treatmentRepository.findById(completeTreatmentToPatient.getTreatmentId());
        if (treatmentOpt.isPresent()) {
            TreatmentModel treatment = treatmentOpt.get();
            treatment.setState(TreatmentModel.State.DONE);
            treatmentRepository.save(treatment);
            TreatmentDTO treatmentDTO = new TreatmentDTO(treatment.getName(), treatment.getType().toString(), treatment.getState().toString());
            return treatmentDTO;
        }

        return new TreatmentDTO();
    }

    public PatientDTO dischargePatient(PatientDTO patientDTO) {

        Optional<PatientModel> patientOpt = patientRepository.findById(patientDTO.getId());
        if (patientOpt.isPresent()) {
            PatientModel patient = patientOpt.get();
            List<DiagnosisModel> diagnosisModels = patient.getDiagnosis();
            for (DiagnosisModel diagnosis : diagnosisModels) {
                diagnosis.setState(DiagnosisModel.State.FINAL);
                diagnosisRepository.save(diagnosis);
            }

            PatientDTO patientOut = new PatientDTO(patient.getId(), patient.getName());
            return patientOut;
        }

        return new PatientDTO();
    }
}

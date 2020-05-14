package hospitalManagment.service;

import hospitalManagment.dto.DiagnosisDTO;
import hospitalManagment.dto.DiagnosisToPatientDTO;
import hospitalManagment.dto.TreatmentDTO;
import hospitalManagment.dto.TreatmentToPatientDTO;
import hospitalManagment.models.DiagnosisModel;
import hospitalManagment.models.TreatmentModel;
import hospitalManagment.repository.iRepository.iDiagnosisRepository;
import hospitalManagment.repository.iRepository.iPatientRepository;
import hospitalManagment.repository.iRepository.iTreatmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log4j2
public class PatientService {

    private final iPatientRepository patientRepository;
    private final iTreatmentRepository treatmentRepository;
    private final iDiagnosisRepository diagnosisRepository;

    public DiagnosisDTO setDiagnosis(DiagnosisToPatientDTO diagnosisToPatient) {

        Optional<DiagnosisModel> diagnosisModelOptional = patientRepository.setDiagnosis(diagnosisToPatient);
        if (diagnosisModelOptional.isPresent()) {
            DiagnosisModel diagnosisModel = diagnosisModelOptional.get();
            return new DiagnosisDTO(diagnosisModel);
        }

        return new DiagnosisDTO();
    }

    public TreatmentDTO setTreatment(TreatmentToPatientDTO treatmentToPatient) {

        Optional<TreatmentModel> treatmentModelOptional = patientRepository.setTreatment(treatmentToPatient);
        if (treatmentModelOptional.isPresent()) {
            TreatmentModel treatmentModel = treatmentModelOptional.get();
            return new TreatmentDTO(treatmentModel.getName(), treatmentModel.getType().toString(), treatmentModel.getState().toString());
        }

        return new TreatmentDTO();
    }

}

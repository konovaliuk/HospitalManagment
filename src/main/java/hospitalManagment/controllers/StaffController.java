package hospitalManagment.controllers;

import hospitalManagment.dto.*;
import hospitalManagment.service.PatientService;
import hospitalManagment.service.StaffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class StaffController {

    private final StaffService staffService;
    private final PatientService patientService;

    @GetMapping("/auth")
    public StaffDTO auth(@RequestBody AuthStaffDTO dto) {
        return this.staffService.authorize(dto.getEmail(), dto.getPassword());
    }

    @PostMapping("/assignDiagnosis")
    public DiagnosisDTO assignDiagnosis(@RequestBody DiagnosisToPatientDTO dto) {
        return this.patientService.setDiagnosis(dto);
    }

    @PostMapping("/assignTreatment")
    public TreatmentDTO assignTreatment(@RequestBody TreatmentToPatientDTO dto) {
        return this.patientService.setTreatment(dto);
    }

    @PostMapping("/completeTreatment")
    public TreatmentDTO completeTreatment(@RequestBody CompleteTreatmentToPatientDTO dto) {
        return this.staffService.completeTreatment(dto);
    }

    @PostMapping("/dischargePatient")
    public PatientDTO dischargePatient(@RequestBody PatientDTO dto) {
        return this.staffService.dischargePatient(dto);
    }

}

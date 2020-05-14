package jdbc.model.services;

import jdbc.model.entities.AssignationsSurgeries;
import jdbc.model.entities.Surgery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AssignationsSurgeriesServiceTest {
    private AssignationsSurgeriesService service;
    private ArrayList<AssignationsSurgeries> surgeries;
    private Surgery surgery;

    @Before
    public void setUp() throws Exception {
        surgery = new Surgery();
        surgery.setId(1);
        surgery.setName("Amputation");

        service = new AssignationsSurgeriesService();
        surgeries = new ArrayList<>();

        surgeries.add(new AssignationsSurgeries.Builder().setId(1)
                .setDiagnosisHistoryId(2)
                .setSurgery(surgery)
                .build());
    }

    @After
    public void tearDown() throws Exception {
        service = null;
        surgeries = null;
        surgery = null;
    }

    @Test
    public void getAssignationSurgeriesByDiagnosisHistoryIdList() {
        List<AssignationsSurgeries> list = service.getAssignationSurgeriesByDiagnosisHistoryIdList(1);

        for (AssignationsSurgeries surgery1 : list) {
            assertEquals(1, surgery1.getDiagnosisHistoryId());
        }
    }

    @Test
    public void createAssignationsSurgeries() {
        service.createAssignationsSurgeries(surgeries);
        AssignationsSurgeries assignationsDrugs = surgeries.get(0);
        boolean test = false;

        List<AssignationsSurgeries> list = service.getAssignationSurgeriesByDiagnosisHistoryIdList(
                assignationsDrugs.getDiagnosisHistoryId());

        for (AssignationsSurgeries surgery1 : list) {
            if (surgery1.equals(assignationsDrugs))
                test = true;
        }

        assertTrue(test);
    }
}
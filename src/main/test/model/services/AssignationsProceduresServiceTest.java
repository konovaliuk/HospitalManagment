package model.services;

import model.entities.AssignationsProcedures;
import model.entities.Procedure;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AssignationsProceduresServiceTest {
    private AssignationsProceduresService service;
    private ArrayList<AssignationsProcedures> procedures;
    private Procedure procedure;

    @Before
    public void setUp() throws Exception {
        procedure = new Procedure();
        procedure.setId(1);
        procedure.setName("Lobobotomy");

        service = new AssignationsProceduresService();
        procedures = new ArrayList<>();

        procedures.add(new AssignationsProcedures.Builder().setId(1)
                .setDiagnosisHistoryId(2)
                .setProcedure(procedure)
                .setNumDays(1)
                .build());
    }

    @After
    public void tearDown() throws Exception {
        service = null;
        procedures = null;
        procedure = null;
    }

    @Test
    public void getAssignationProceduresByDiagnosisHistoryIdList() {
        List<AssignationsProcedures> list = service.getAssignationProceduresByDiagnosisHistoryIdList(1);

        for (AssignationsProcedures procedure1 : list) {
            assertEquals(1, procedure1.getDiagnosisHistoryId());
        }
    }

    @Test
    public void createAssignationsProcedures() {
        service.createAssignationsProcedures(procedures);
        AssignationsProcedures assignationsProcedures = procedures.get(0);
        boolean test = false;

        List<AssignationsProcedures> list = service.getAssignationProceduresByDiagnosisHistoryIdList(
                assignationsProcedures.getDiagnosisHistoryId());

        for (AssignationsProcedures procedures1 : list) {
            if (procedures1.equals(assignationsProcedures))
                test = true;
        }

        assertTrue(test);
    }
}
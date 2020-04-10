package model.services;

import model.entities.AssignationsDrugs;
import model.entities.Drug;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.naming.Context;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AssignationsDrugsServiceTest {
    private AssignationsDrugsService service;
    private ArrayList<AssignationsDrugs> drugs;
    private Drug drug;

    @Before
    public void setUp() throws Exception {
        drug = new Drug();
        drug.setId(1);
        drug.setName("Alkazelcer");

         service = new AssignationsDrugsService();
         drugs = new ArrayList<>();

         drugs.add(new AssignationsDrugs.Builder().setId(1)
         .setDiagnosisHistoryId(22)
         .setDrug(drug)
         .setNumDays(1)
         .setNumTimes(1)
         .setNumUnits(1)
         .build());
    }

    @After
    public void tearDown() throws Exception {
        service = null;
        drugs = null;
        drug = null;
    }

    @Test
    public void getAssignationDrugsByDiagnosisHistoryIdList() {
       List<AssignationsDrugs> list = service.getAssignationDrugsByDiagnosisHistoryIdList(1);

       for (AssignationsDrugs drug1 : list) {
           assertEquals(1, drug1.getDiagnosisHistoryId());
       }
    }

    @Test
    public void createAssignationDrug() {
        service.createAssignationDrug(drugs);
        AssignationsDrugs assignationsDrugs = drugs.get(0);
        boolean test = false;

        List<AssignationsDrugs> list = service.getAssignationDrugsByDiagnosisHistoryIdList(
                assignationsDrugs.getDiagnosisHistoryId());

        for (AssignationsDrugs drug1 : list) {
            if (drug1.equals(assignationsDrugs))
                test = true;
        }

        assertTrue(test);
    }
}
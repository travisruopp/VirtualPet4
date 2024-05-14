package org.wecancodeit.virtualpet4;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.wecancodeit.virtualpet4.Models.PetMaintenanceModel;
import org.wecancodeit.virtualpet4.Repositories.PetMaintenanceRepository;

@SpringBootTest
public class PetMaintenanceTest {
    @Test
    public void getByID() throws Exception{
        PetMaintenanceRepository petMaintenanceRepository = new PetMaintenanceRepository("http://localhost:8080/api/v1/petMaintenances/");
        PetMaintenanceModel model = petMaintenanceRepository.getById(1l);
        assertEquals(1l, model.getId());
    }
    
    @Test
    public void getAll() throws Exception{
        PetMaintenanceRepository petMaintenance = new PetMaintenanceRepository("http://localhost:8080/api/v1/petMaintenances/");
        Collection<PetMaintenanceModel> model = petMaintenance.getAll("");
        assertEquals(model.iterator().next().getId(), 1);
    }
}
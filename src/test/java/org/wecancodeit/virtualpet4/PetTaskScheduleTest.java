package org.wecancodeit.virtualpet4;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.wecancodeit.virtualpet4.Models.PetTaskScheduleModel;
import org.wecancodeit.virtualpet4.Repositories.PetTaskScheduleRepository;

@SpringBootTest
public class PetTaskScheduleTest {
    @Test
    public void getByID() throws Exception{
        PetTaskScheduleRepository petTaskScheduleRepository = new PetTaskScheduleRepository("http://localhost:8080/api/v1/petTaskSchedules/");
        PetTaskScheduleModel model = petTaskScheduleRepository.getByID(1l);
        assertEquals(1l, model.getID());
    }
    
    @Test
    public void getAll() throws Exception{
        PetTaskScheduleRepository petTaskSchedule = new PetTaskScheduleRepository("http://localhost:8080/api/v1/petTaskSchedules/");
        Collection<PetTaskScheduleModel> model = petTaskSchedule.getAll("");
        assertEquals(model.iterator().next().getID(), 1);
    }
}
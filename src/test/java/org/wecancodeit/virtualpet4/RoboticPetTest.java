package org.wecancodeit.virtualpet4;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.wecancodeit.virtualpet4.Models.RoboticPetModel;
import org.wecancodeit.virtualpet4.Repositories.RoboticPetRepository;

@SpringBootTest
public class RoboticPetTest {
    @Test
    public void getByID() throws Exception{
        RoboticPetRepository roboticPetRepository = new RoboticPetRepository("http://localhost:8080/api/v1/roboticPets/");
        RoboticPetModel model = roboticPetRepository.getById(1l);
        assertEquals(1l, model.getId());
    }
    
    @Test
    public void getAll() throws Exception{
        RoboticPetRepository roboticPet = new RoboticPetRepository("http://localhost:8080/api/v1/roboticPets/");
        Collection<RoboticPetModel> model = roboticPet.getAll("");
        assertEquals(model.iterator().next().getId(), 1);
    }
}

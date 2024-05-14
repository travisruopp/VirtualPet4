package org.wecancodeit.virtualpet4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.wecancodeit.virtualpet4.Models.OrganicPetModel;
import org.wecancodeit.virtualpet4.Repositories.OrganicPetRepository;

@SpringBootTest
public class OrganicPetTest {
    @Test
    public void getByID() throws Exception{
        OrganicPetRepository organicPetRepository = new OrganicPetRepository("http://localhost:8080/api/v1/organicPets/");
        OrganicPetModel model = organicPetRepository.getById(1l);
        assertEquals(1l, model.getId());
    }
    
    @Test
    public void getAll() throws Exception{
        OrganicPetRepository organicPet = new OrganicPetRepository("http://localhost:8080/api/v1/organicPets/");
        Collection<OrganicPetModel> model = organicPet.getAll("");
        assertEquals(model.iterator().next().getId(), 1);
    }
}

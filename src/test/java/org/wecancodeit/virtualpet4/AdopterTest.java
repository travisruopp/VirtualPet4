package org.wecancodeit.virtualpet4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.wecancodeit.virtualpet4.Models.AdopterModel;
import org.wecancodeit.virtualpet4.Repositories.AdopterRepository;

@SpringBootTest
public class AdopterTest {
    @Test
    public void getByID() throws Exception {
        AdopterRepository adopterRepository = new AdopterRepository("http://localhost:8080/api/v1/adopters/");
        AdopterModel model = adopterRepository.getById(1l);
        assertEquals(1l, model.getId());
    }

    @Test
    public void getAll() throws Exception {
        AdopterRepository adopter = new AdopterRepository("http://localhost:8080/api/v1/adopters/");
        Collection<AdopterModel> model = adopter.getAll("");
        assertEquals(model.iterator().next().getId(), 1);
    }
}

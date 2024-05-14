package org.wecancodeit.virtualpet4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.wecancodeit.virtualpet4.Models.VolunteerModel;
import org.wecancodeit.virtualpet4.Repositories.VolunteerRepository;

@SpringBootTest
public class VolunteerTest {
    @Test
    public void getById() throws Exception {
        VolunteerRepository volunteerRepository = new VolunteerRepository("http://localhost:8080/api/v1/volunteers/");
        VolunteerModel model = volunteerRepository.getById(1l);
        assertEquals(1l, model.getId());
    }

    @Test
    public void getAll() throws Exception {
        VolunteerRepository volunteer = new VolunteerRepository("http://localhost:8080/api/v1/volunteers/");
        Collection<VolunteerModel> model = volunteer.getAll("");
        assertEquals(model.iterator().next().getId(), 1);
    }
}
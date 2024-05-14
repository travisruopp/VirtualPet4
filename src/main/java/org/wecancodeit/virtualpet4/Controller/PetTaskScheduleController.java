package org.wecancodeit.virtualpet4.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.virtualpet4.Repositories.*;


@Controller
@RequestMapping("/petTaskSchedules")
public class PetTaskScheduleController {

    @GetMapping
    public String getPetTaskSchedules(Model model) throws Exception {
        PetTaskScheduleRepository petTaskSchedule = new PetTaskScheduleRepository("http://localhost:8080/api/v1/petTaskSchedules/");
        var petTaskSchedules = petTaskSchedule.getAll("");
        model.addAttribute("petTaskSchedules", petTaskSchedules);
        return "petTaskSchedules/petTaskSchedules";
    }

    @GetMapping("/{id}")
    public String getPetTaskSchedule(@PathVariable Long id, Model model) throws Exception{
        PetTaskScheduleRepository petTaskSchedule = new PetTaskScheduleRepository("http://localhost:8080/api/v1/petTaskSchedules/");
        var petTaskSchedules = petTaskSchedule.getByID(id);
        model.addAttribute("petTaskSchedule", petTaskSchedules);
        return "petTaskSchedules/petTaskScheduleDetails";
    }

    @GetMapping("/edit/{id}")
    public String editPetTaskSchedule(@PathVariable Long id, Model model) throws Exception{
        PetTaskScheduleRepository petTaskSchedule = new PetTaskScheduleRepository("http://localhost:8080/api/v1/petTaskSchedules/");
        var petTaskSchedules = petTaskSchedule.getByID(id);
        model.addAttribute("petTaskSchedule", petTaskSchedules);
        return "petTaskSchedules/petTaskScheduleEdit";
    }
}

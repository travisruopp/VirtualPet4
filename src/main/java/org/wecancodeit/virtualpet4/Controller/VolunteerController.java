package org.wecancodeit.virtualpet4.Controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.virtualpet4.Dto.VolunteerDto;
import org.wecancodeit.virtualpet4.Models.ShelterModel;
import org.wecancodeit.virtualpet4.Models.VolunteerModel;
import org.wecancodeit.virtualpet4.Repositories.*;

/**
 * Class that models the volunteer controller
 */
@Controller
@RequestMapping("/volunteers")
public class VolunteerController {

    private final VolunteerRepository volunteerRepository;

    /**
     * Constructor
     */
    public VolunteerController() {
        volunteerRepository = new VolunteerRepository("http://localhost:8080/api/v1/volunteers/");
    }

    /**
     * Method that gets all volunteers
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping
    public String getVolunteers(Model model) throws Exception {
        Collection<VolunteerModel> volunteers = volunteerRepository.getAll("");
        model.addAttribute("volunteers", volunteers);
        return "volunteers/volunteers";
    }

    /**
     * Method to get a specific volunteer
     * 
     * @param id    volunteer id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/{id}")
    public String getVolunteer(@PathVariable Long id, Model model) throws Exception {
        VolunteerModel volunteer = volunteerRepository.getById(id);
        model.addAttribute("volunteer", volunteer);
        return "volunteers/volunteerDetails";
    }

    /**
     * Method to delete a specific volunteer
     * 
     * @param id    volunteer id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/delete/{id}")
    public String deleteVolunteer(@PathVariable Long id, Model model) throws Exception {
        VolunteerModel volunteerModel = volunteerRepository.getById(id);
        model.addAttribute("volunteer", volunteerModel);
        return "volunteers/volunteerConfirmDelete";
    }

    /**
     * Method to confirm if a user wants to delete a specific volunteer
     * 
     * @param id    volunteer id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * @throws Exception
     */
    @GetMapping("/delete/volunteerConfirmDelete/{id}")
    public String deleteItem(@PathVariable Long id, Model model) throws Exception {
        volunteerRepository.deleteById(id);
        Collection<VolunteerModel> volunteers = volunteerRepository.getAll("");
        model.addAttribute("volunteers", volunteers);
        return "redirect:/volunteers";
    }

    /**
     * Method to save a specific volunteer
     * 
     * @param volunteerDto volunteer data transfer object to save
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @PostMapping("/save")
    public String saveVolunteer(@ModelAttribute("volunteer") VolunteerDto volunteerDto) throws Exception {
        volunteerRepository.saveVolunteer(volunteerDto.convertToModel());
        return "redirect:/volunteers";
    }

    /**
     * Method to add a new volunteer
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/create")
    public String addVolunteer(Model model) throws Exception {
        VolunteerDto volunteerDto = new VolunteerDto();
        model.addAttribute("volunteer", volunteerDto);
        model.addAttribute("title", "Create Volunteer");
        return "volunteers/volunteerEdit";
    }

    /**
     * Method to edit a specific volunteer
     * 
     * @param id    volunteer ID
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/edit/{id}")
    public String editDetails(@PathVariable Long id, Model model) throws Exception {
        VolunteerModel volunteer = volunteerRepository.getById(id);
        VolunteerDto volunteerDto = new VolunteerDto(volunteer);
        model.addAttribute("volunteer", volunteerDto);
        model.addAttribute("title", "Edit Volunteer");
        return "volunteers/volunteerEdit";
    }
}

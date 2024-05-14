package org.wecancodeit.virtualpet4.Controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.virtualpet4.Dto.ShelterDto;
import org.wecancodeit.virtualpet4.Models.ShelterModel;
import org.wecancodeit.virtualpet4.Repositories.*;

/**
 * Class that models the shelter controller
 */
@Controller
@RequestMapping("/shelters")
public class ShelterController {

    private final ShelterRepository shelterRepository;

    /**
     * Constructor
     */
    public ShelterController() {
        shelterRepository = new ShelterRepository("http://localhost:8080/api/v1/shelters/");
    }

    /**
     * Method that gets all shelters
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping
    public String getShelters(Model model) throws Exception {
        Collection<ShelterModel> shelters = shelterRepository.getAll("");
        model.addAttribute("shelters", shelters);
        return "shelters/shelters";
    }

    /**
     * Method to get a specific shelter
     * 
     * @param id    shelter id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/{id}")
    public String getShelter(@PathVariable Long id, Model model) throws Exception {
        ShelterModel shelter = shelterRepository.getById(id);
        model.addAttribute("shelter", shelter);
        return "shelters/shelterDetails";
    }

    /**
     * Method to delete a specific shelter
     * 
     * @param id    shelter id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/delete/{id}")
    public String deleteShelter(@PathVariable Long id, Model model) throws Exception {
        ShelterModel shelterModel = shelterRepository.getById(id);
        model.addAttribute("shelter", shelterModel);
        return "shelters/shelterConfirmDelete";
    }

    /**
     * Method to confirm if a user wants to delete a specific shelter
     * 
     * @param id    shelter id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * @throws Exception
     */
    @GetMapping("/delete/shelterConfirmDelete/{id}")
    public String deleteItem(@PathVariable Long id, Model model) throws Exception {
        shelterRepository.deleteById(id);
        Collection<ShelterModel> shelters = shelterRepository.getAll("");
        model.addAttribute("shelters", shelters);
        return "redirect:/shelters";
    }

    /**
     * Method to save a specific shelter
     * 
     * @param shelterDto shelter data transfer object to save
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @PostMapping("/save")
    public String saveShelter(@ModelAttribute("shelter") ShelterDto shelterDto) throws Exception {
        shelterRepository.saveShelter(shelterDto.convertToModel());
        return "redirect:/shelters";
    }

    /**
     * Method to add a new shelter
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/create")
    public String addShelter(Model model) throws Exception {
        ShelterDto shelterDto = new ShelterDto();
        model.addAttribute("shelter", shelterDto);
        model.addAttribute("title", "Create Shelter");
        return "shelters/shelterEdit";
    }

    /**
     * Method to edit a specific shelter
     * 
     * @param id    shelter ID
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/edit/{id}")
    public String editDetails(@PathVariable Long id, Model model) throws Exception {
        ShelterModel shelter = shelterRepository.getById(id);
        ShelterDto shelterDto = new ShelterDto(shelter);
        model.addAttribute("shelter", shelterDto);
        model.addAttribute("title", "Edit Shelter");
        return "shelters/shelterEdit";
    }
}

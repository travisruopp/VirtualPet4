package org.wecancodeit.virtualpet4.Controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.virtualpet4.Dto.PetMaintenanceDto;
import org.wecancodeit.virtualpet4.Models.PetMaintenanceModel;
import org.wecancodeit.virtualpet4.Models.Enums.*;
import org.wecancodeit.virtualpet4.Repositories.*;

@Controller
@RequestMapping("/petMaintenances")
public class PetMaintenanceController {

    private final PetMaintenanceRepository petMaintenanceRepository;
    /**
     * Constructor
     */
    public PetMaintenanceController() {
        petMaintenanceRepository = new PetMaintenanceRepository("http://localhost:8080/api/v1/petMaintenances/");
    }

    /**
     * Method that gets all petMaintenances
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping
    public String getPetMaintenances(Model model) throws Exception {
        Collection<PetMaintenanceModel> petMaintenances = petMaintenanceRepository.getAll("");
        model.addAttribute("petMaintenances", petMaintenances);
        return "petMaintenances/petMaintenances";
    }

    /**
     * Method to get a specific petMaintenance
     * 
     * @param id    petMaintenance id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/{id}")
    public String getPetMaintenance(@PathVariable Long id, Model model) throws Exception {
        PetMaintenanceModel petMaintenance = petMaintenanceRepository.getById(id);
        model.addAttribute("petMaintenance", petMaintenance);
        return "petMaintenances/petMaintenanceDetails";
    }

    /**
     * Method to delete a specific petMaintenance
     * 
     * @param id    petMaintenance id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/delete/{id}")
    public String deletePetMaintenance(@PathVariable Long id, Model model) throws Exception {
        PetMaintenanceModel petMaintenanceModel = petMaintenanceRepository.getById(id);
        model.addAttribute("petMaintenance", petMaintenanceModel);
        return "petMaintenances/petMaintenanceConfirmDelete";
    }

    /**
     * Method to confirm if a user wants to delete a specific petMaintenance
     * 
     * @param id    petMaintenance id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * @throws Exception
     */
    @GetMapping("/delete/petMaintenanceConfirmDelete/{id}")
    public String deleteItem(@PathVariable Long id, Model model) throws Exception {
        petMaintenanceRepository.deleteById(id);
        Collection<PetMaintenanceModel> petMaintenances = petMaintenanceRepository.getAll("");
        model.addAttribute("petMaintenances", petMaintenances);
        return "redirect:/petMaintenances";
    }

    /**
     * Method to save a specific petMaintenance
     * 
     * @param petMaintenanceDto petMaintenance data transfer object to save
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @PostMapping("/save")
    public String savePetMaintenance(@ModelAttribute("petMaintenance") PetMaintenanceDto petMaintenanceDto) throws Exception {
        petMaintenanceRepository.savePetMaintenance(petMaintenanceDto.convertToModel());
        return "redirect:/petMaintenances";
    }

    /**
     * Method to add a new petMaintenance
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/create")
    public String addPetMaintenance(Model model) throws Exception {
        PetMaintenanceDto petMaintenanceDto = new PetMaintenanceDto();
        model.addAttribute("petMaintenance", petMaintenanceDto);
        model.addAttribute("title", "Create Pet Maintenance");
        List<String> listPetType = enumToList(PetTypeEnum.class);
        model.addAttribute("listPetType", listPetType);
        List<String> listEffectedProperty = enumToList(PetTaskEnum.class);
        model.addAttribute("listEffectedProperty", listEffectedProperty);
        return "petMaintenances/petMaintenanceEdit";
    }

    /**
     * Method to edit a specific petMaintenance
     * 
     * @param id    petMaintenance ID
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/edit/{id}")
    public String editPetMaintenance(@PathVariable Long id, Model model) throws Exception {
        PetMaintenanceRepository petMaintenance = new PetMaintenanceRepository("http://localhost:8080/api/v1/petMaintenances/");
        var petMaintenances = petMaintenance.getById(id);
        model.addAttribute("petMaintenance", petMaintenances);
        model.addAttribute("title", "Edit Pet Maintenance");
        List<String> listPetType = enumToList(PetTypeEnum.class);
        model.addAttribute("listPetType", listPetType);
        List<String> listPetHealth = enumToList(PetTaskEnum.class);
        model.addAttribute("listPetHealth", listPetHealth);
        return "petMaintenances/petMaintenanceEdit";
    }

    /**
     * Method that converts an enum to a list
     * 
     * @param <T> 
     * @param class1 Enum to convert
     * @return
     */
    public <T extends Enum<T>> List<String> enumToList(Class<T> class1) {
        List<String> list = new ArrayList<>();
        T[] enumConstants = class1.getEnumConstants();
        for (T enumConstant : enumConstants) {
            list.add(enumConstant.name());
        }
        return list;
    }
}
package org.wecancodeit.virtualpet4.Controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.virtualpet4.Dto.AdopterDto;
import org.wecancodeit.virtualpet4.Models.AdopterModel;
import org.wecancodeit.virtualpet4.Models.ShelterModel;
import org.wecancodeit.virtualpet4.Models.Enums.*;
import org.wecancodeit.virtualpet4.Repositories.*;

/**
 * Class that models the adopter controller
 */
@Controller
@RequestMapping("/adopters")
public class AdopterController {

    private final AdopterRepository adopterRepository;
    private final ShelterRepository shelterRepository;

    /**
     * Constructor
     */
    public AdopterController() {
        adopterRepository = new AdopterRepository("http://localhost:8080/api/v1/adopters/");
        shelterRepository = new ShelterRepository("http://localhost:8080/api/v1/shelters/");
    }

    /**
     * Method that gets all adopters
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping
    public String getAdopters(Model model) throws Exception {
        Collection<AdopterModel> adopters = adopterRepository.getAll("");
        model.addAttribute("adopters", adopters);
        return "adopters/adopters";
    }

    /**
     * Method to get a specific adopter
     * 
     * @param id    adopter id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/{id}")
    public String getAdopter(@PathVariable Long id, Model model) throws Exception {
        AdopterModel adopter = adopterRepository.getById(id);
        model.addAttribute("adopter", adopter);
        return "adopters/adopterDetails";
    }

    /**
     * Method to delete a specific adopter
     * 
     * @param id    adopter id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/delete/{id}")
    public String deleteAdopter(@PathVariable Long id, Model model) throws Exception {
        AdopterModel adopterModel = adopterRepository.getById(id);
        model.addAttribute("adopter", adopterModel);
        return "adopters/adopterConfirmDelete";
    }

    /**
     * Method to confirm if a user wants to delete a specific adopter
     * 
     * @param id    adopter id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * @throws Exception
     */
    @GetMapping("/delete/adopterConfirmDelete/{id}")
    public String deleteItem(@PathVariable Long id, Model model) throws Exception {
        adopterRepository.deleteById(id);
        Collection<AdopterModel> adopters = adopterRepository.getAll("");
        model.addAttribute("adopters", adopters);
        return "redirect:/adopters";
    }

    /**
     * Method to save a specific adopter
     * 
     * @param adopterDto adopter data transfer object to save
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @PostMapping("/save")
    public String saveAdopter(@ModelAttribute("adopter") AdopterDto adopterDto) throws Exception {
        AdopterModel adopter = adopterDto.convertToModel();
        ShelterModel shelter = shelterRepository.getById(adopterDto.getShelterId());
        adopter.setShelterModel(shelter);
        adopterRepository.saveAdopter(adopter);
        return "redirect:/adopters";
    }

    /**
     * Method to add a new adopter
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/create")
    public String addAdopter(Model model) throws Exception {
        AdopterDto adopterDto = new AdopterDto();
        model.addAttribute("adopter", adopterDto);
        model.addAttribute("title", "Create Adopter");
        model.addAttribute("shelters", shelterRepository.getLookup());
        List<String> listPreferredPetType = enumToList(PetTypeEnum.class);
        model.addAttribute("listPreferredPetType", listPreferredPetType);
        List<String> listAdoptionStatus = enumToList(AdoptionStatusEnum.class);
        model.addAttribute("listAdoptionStatus", listAdoptionStatus);
        return "adopters/adopterEdit";
    }

    /**
     * Method to edit a specific adopter
     * 
     * @param id    adopter ID
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/edit/{id}")
    public String editDetails(@PathVariable Long id, Model model) throws Exception {
        AdopterModel adopter = adopterRepository.getById(id);
        AdopterDto adopterDto = new AdopterDto(adopter);
        model.addAttribute("adopter", adopterDto);
        model.addAttribute("title", "Edit Adopter");
        model.addAttribute("shelters", shelterRepository.getLookup());
        List<String> listPreferredPetType = enumToList(PetTypeEnum.class);
        model.addAttribute("listPreferredPetType", listPreferredPetType);
        List<String> listAdoptionStatus = enumToList(AdoptionStatusEnum.class);
        model.addAttribute("listAdoptionStatus", listAdoptionStatus);
        return "adopters/adopterEdit";
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
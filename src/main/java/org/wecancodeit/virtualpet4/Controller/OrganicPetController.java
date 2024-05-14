package org.wecancodeit.virtualpet4.Controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.virtualpet4.Dto.OrganicPetDto;
import org.wecancodeit.virtualpet4.Models.OrganicPetModel;
import org.wecancodeit.virtualpet4.Models.ShelterModel;
import org.wecancodeit.virtualpet4.Models.Enums.*;
import org.wecancodeit.virtualpet4.Repositories.*;

@Controller
@RequestMapping("/organicPets")
public class OrganicPetController {
    private final OrganicPetRepository organicPetRepository;
    private final ShelterRepository shelterRepository;

    /**
     * Constructor
     */
    public OrganicPetController() {
        organicPetRepository = new OrganicPetRepository("http://localhost:8080/api/v1/organicPets/");
        shelterRepository = new ShelterRepository("http://localhost:8080/api/v1/shelters/");
    }

    /**
     * Method that gets all organicPets
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping
    public String getOrganicPets(Model model) throws Exception {
        Collection<OrganicPetModel> organicPets = organicPetRepository.getAll("");
        model.addAttribute("organicPets", organicPets);
        return "organicPets/organicPets";
    }

    /**
     * Method to get a specific organicPet
     * 
     * @param id    organicPet id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/{id}")
    public String getOrganicPet(@PathVariable Long id, Model model) throws Exception {
        OrganicPetModel organicPet = organicPetRepository.getById(id);
        model.addAttribute("organicPet", organicPet);
        return "organicPets/organicPetDetails";
    }

    /**
     * Method to delete a specific organicPet
     * 
     * @param id    organicPet id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/delete/{id}")
    public String deleteOrganicPet(@PathVariable Long id, Model model) throws Exception {
        OrganicPetModel organicPetModel = organicPetRepository.getById(id);
        model.addAttribute("organicPet", organicPetModel);
        return "organicPets/organicPetConfirmDelete";
    }

    /**
     * Method to confirm if a user wants to delete a specific organicPet
     * 
     * @param id    organicPet id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * @throws Exception
     */
    @GetMapping("/delete/organicPetConfirmDelete/{id}")
    public String deleteItem(@PathVariable Long id, Model model) throws Exception {
        organicPetRepository.deleteById(id);
        Collection<OrganicPetModel> organicPets = organicPetRepository.getAll("");
        model.addAttribute("organicPets", organicPets);
        return "redirect:/organicPets";
    }

    /**
     * Method to save a specific organicPet
     * 
     * @param organicPetDto organicPet data transfer object to save
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @PostMapping("/save")
    public String saveOrganicPet(@ModelAttribute("organicPet") OrganicPetDto organicPetDto) throws Exception {
        OrganicPetModel organicPetModel = organicPetDto.convertToModel();
        ShelterModel shelter = shelterRepository.getById(organicPetDto.getShelterId());
        organicPetModel.setShelterModel(shelter);
        organicPetRepository.saveOrganicPet(organicPetModel);
        return "redirect:/organicPets";
    }

    /**
     * Method to add a new organicPet
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/create")
    public String addOrganicPet(Model model) throws Exception {
        OrganicPetDto organicPetDto = new OrganicPetDto();
        model.addAttribute("organicPet", organicPetDto);
        model.addAttribute("title", "Create OrganicPet");
        model.addAttribute("shelters", shelterRepository.getLookup());
        List<String> listPetType = enumToList(PetTypeEnum.class);
        model.addAttribute("listPetType", listPetType);
        List<String> listPetHealth = enumToList(PetHealthEnum.class);
        model.addAttribute("listPetHealth", listPetHealth);
        List<String> listPetMood = enumToList(PetMoodEnum.class);
        model.addAttribute("listPetMood", listPetMood);
        List<String> listPetTemperament = enumToList(PetTemperamentEnum.class);
        model.addAttribute("listPetTemperament", listPetTemperament);
        return "organicPets/organicPetEdit";
    }

    /**
     * Method to edit a specific organicPet
     * 
     * @param id    organicPet ID
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/edit/{id}")
    public String editOrganicPet(@PathVariable Long id, Model model) throws Exception {
        OrganicPetModel organicPet = organicPetRepository.getById(id);
        OrganicPetDto organicPetDto = new OrganicPetDto(organicPet);
        model.addAttribute("organicPet", organicPetDto);
        model.addAttribute("title", "Edit OrganicPet");
        model.addAttribute("shelters", shelterRepository.getLookup());
        List<String> listPetType = enumToList(PetTypeEnum.class);
        model.addAttribute("listPetType", listPetType);
        List<String> listPetHealth = enumToList(PetHealthEnum.class);
        model.addAttribute("listPetHealth", listPetHealth);
        List<String> listPetMood = enumToList(PetMoodEnum.class);
        model.addAttribute("listPetMood", listPetMood);
        List<String> listPetTemperament = enumToList(PetTemperamentEnum.class);
        model.addAttribute("listPetTemperament", listPetTemperament);
        return "organicPets/organicPetEdit";
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
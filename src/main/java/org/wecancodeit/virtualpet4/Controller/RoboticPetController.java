package org.wecancodeit.virtualpet4.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.virtualpet4.Dto.RoboticPetDto;
import org.wecancodeit.virtualpet4.Models.RoboticPetModel;
import org.wecancodeit.virtualpet4.Models.Enums.*;
import org.wecancodeit.virtualpet4.Repositories.*;

/**
 * Class that models the robotic pet controller
 */
@Controller
@RequestMapping("/roboticPets")
public class RoboticPetController {
    private final RoboticPetRepository roboticPetRepository;
    private final ShelterRepository shelterRepository;

    /**
     * Constructor
     */
    public RoboticPetController() {
        roboticPetRepository = new RoboticPetRepository("http://localhost:8080/api/v1/roboticPets/");
        shelterRepository = new ShelterRepository("http://localhost:8080/api/v1/shelters/");
    }

    /**
     * Method that gets all roboticPets
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping
    public String getRoboticPets(Model model) throws Exception {
        Collection<RoboticPetModel> roboticPets = roboticPetRepository.getAll("");
        model.addAttribute("roboticPets", roboticPets);
        return "roboticPets/roboticPets";
    }

    /**
     * Method to get a specific roboticPet
     * 
     * @param id    roboticPet id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/{id}")
    public String getRoboticPet(@PathVariable Long id, Model model) throws Exception {
        RoboticPetModel roboticPet = roboticPetRepository.getById(id);
        model.addAttribute("roboticPet", roboticPet);
        return "roboticPets/roboticPetDetails";
    }

    /**
     * Method to delete a specific roboticPet
     * 
     * @param id    roboticPet id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/delete/{id}")
    public String deleteRoboticPet(@PathVariable Long id, Model model) throws Exception {
        RoboticPetModel roboticPetModel = roboticPetRepository.getById(id);
        model.addAttribute("roboticPet", roboticPetModel);
        return "roboticPets/roboticPetConfirmDelete";
    }

    /**
     * Method to confirm if a user wants to delete a specific roboticPet
     * 
     * @param id    roboticPet id
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * @throws Exception
     */
    @GetMapping("/delete/roboticPetConfirmDelete/{id}")
    public String deleteItem(@PathVariable Long id, Model model) throws Exception {
        roboticPetRepository.deleteById(id);
        Collection<RoboticPetModel> roboticPets = roboticPetRepository.getAll("");
        model.addAttribute("roboticPets", roboticPets);
        return "redirect:/roboticPets";
    }

    /**
     * Method to save a specific roboticPet
     * 
     * @param roboticPetDto roboticPet data transfer object to save
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @PostMapping("/save")
    public String saveRoboticPet(@ModelAttribute("roboticPet") RoboticPetDto roboticPetDto) throws Exception {
        roboticPetRepository.saveRoboticPet(roboticPetDto.convertToModel());
        return "redirect:/roboticPets";
    }

    /**
     * Method to add a new roboticPet
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/create")
    public String addRoboticPet(Model model) throws Exception {
        RoboticPetDto roboticPetDto = new RoboticPetDto();
        model.addAttribute("roboticPet", roboticPetDto);
        model.addAttribute("title", "Create RoboticPet");
        model.addAttribute("shelters", shelterRepository.getLookup());
        List<String> listPetType = enumToList(PetTypeEnum.class);
        model.addAttribute("listPetType", listPetType);
        List<String> listPetHealth = enumToList(RoboticPetHealthEnum.class);
        model.addAttribute("listPetHealth", listPetHealth);
        return "roboticPets/roboticPetEdit";
    }

    /**
     * Method to edit a specific roboticPet
     * 
     * @param id    roboticPet ID
     * 
     * @param model spring boot base model
     * 
     * @return webpage to map
     * 
     * @throws Exception
     */
    @GetMapping("/edit/{id}")
    public String editRoboticPet(@PathVariable Long id, Model model) throws Exception {
        RoboticPetModel roboticPetModel = roboticPetRepository.getById(id);
        RoboticPetDto roboticPetDto = new RoboticPetDto(roboticPetModel);
        model.addAttribute("roboticPet", roboticPetDto);
        model.addAttribute("title", "Edit RoboticPet");
        model.addAttribute("shelters", shelterRepository.getLookup());
        List<String> listPetType = enumToList(PetTypeEnum.class);
        model.addAttribute("listPetType", listPetType);
        List<String> listPetHealth = enumToList(RoboticPetHealthEnum.class);
        model.addAttribute("listPetHealth", listPetHealth);
        return "roboticPets/roboticPetEdit";
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

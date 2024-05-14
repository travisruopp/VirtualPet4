package org.wecancodeit.virtualpet4.Repositories;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.wecancodeit.virtualpet4.Models.RoboticPetModel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class RoboticPetRepository extends ClientHTTP{
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Parameterized constructor
     * 
     * @param baseURLString Base API URL
     */
    public RoboticPetRepository(String baseURLString) {
        super(baseURLString);
    }

    /**
     * Method to get the id of the roboticPet
     * 
     * @param id roboticPet id
     * 
     * @return roboticPet id
     * @throws Exception
     */
    public RoboticPetModel getById(Long id) throws Exception {
        String model = getURL(id.toString());
        RoboticPetModel result = objectMapper.readValue(model, RoboticPetModel.class);
        return result;
    }

    /**
     * Method to get all roboticPets
     * 
     * @param urlPath url for the API of all roboticPets
     * 
     * @return all roboticPets
     * 
     * @throws Exception
     */
    public Collection<RoboticPetModel> getAll(String urlPath) throws Exception {
        List<RoboticPetModel> roboticPetList = null;
        try {
            String jsonString = getURL(urlPath);
            // Convert JSON string to List
            roboticPetList = objectMapper.readValue(jsonString, new TypeReference<List<RoboticPetModel>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roboticPetList;
    }

    /**
     * Method to delete roboticPet
     * 
     * @param id roboticPet id
     * 
     * @return if the roboticPet was deleted
     * 
     * @throws Exception
     */
    public boolean deleteById(Long id) throws Exception {
        return deleteObject(id);
    }

    /**
     * Method to save an roboticPet
     * 
     * @param roboticPetModel roboticPet model to save
     * 
     * @return roboticPet model
     * 
     * @throws Exception
     */
    public RoboticPetModel saveRoboticPet(RoboticPetModel roboticPetModel) throws Exception {
        try {
            String json = objectMapper.writeValueAsString(roboticPetModel);
            String result = saveObject(json);
            roboticPetModel = objectMapper.readValue(result, new TypeReference<RoboticPetModel>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roboticPetModel;
    }
}

package org.wecancodeit.virtualpet4.Repositories;

import java.io.IOException;
import java.util.*;
import org.wecancodeit.virtualpet4.Models.OrganicPetModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class that models the organicPet repository.
 */
public class OrganicPetRepository extends ClientHTTP {
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Parameterized constructor
     * 
     * @param baseURLString Base API URL
     */
    public OrganicPetRepository(String baseURLString) {
        super(baseURLString);
    }

    /**
     * Method to get the id of the organicPet
     * 
     * @param id organicPet id
     * 
     * @return organicPet id
     * @throws Exception
     */
    public OrganicPetModel getById(Long id) throws Exception {
        String model = getURL(id.toString());
        OrganicPetModel result = objectMapper.readValue(model, OrganicPetModel.class);
        return result;
    }

    /**
     * Method to get all organicPets
     * 
     * @param urlPath url for the API of all organicPets
     * 
     * @return all organicPets
     * 
     * @throws Exception
     */
    public Collection<OrganicPetModel> getAll(String urlPath) throws Exception {
        List<OrganicPetModel> organicPetList = null;
        try {
            String jsonString = getURL(urlPath);
            // Convert JSON string to List
            organicPetList = objectMapper.readValue(jsonString, new TypeReference<List<OrganicPetModel>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return organicPetList;
    }

    /**
     * Method to delete organicPet
     * 
     * @param id organicPet id
     * 
     * @return if the organicPet was deleted
     * 
     * @throws Exception
     */
    public boolean deleteById(Long id) throws Exception {
        return deleteObject(id);
    }

    /**
     * Method to save an organicPet
     * 
     * @param organicPetModel organicPet model to save
     * 
     * @return organicPet model
     * 
     * @throws Exception
     */
    public OrganicPetModel saveOrganicPet(OrganicPetModel organicPetModel) throws Exception {
        try {
            String json = objectMapper.writeValueAsString(organicPetModel);
            String result = saveObject(json);
            organicPetModel = objectMapper.readValue(result, new TypeReference<OrganicPetModel>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return organicPetModel;
    }
}

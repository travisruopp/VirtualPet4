package org.wecancodeit.virtualpet4.Repositories;

import java.io.IOException;
import java.util.*;
import org.wecancodeit.virtualpet4.Models.AdopterModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class that models the adopter repository.
 */
public class AdopterRepository extends ClientHTTP {
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Parameterized constructor
     * 
     * @param baseURLString Base API URL
     */
    public AdopterRepository(String baseURLString) {
        super(baseURLString);
    }

    /**
     * Method to get the id of the adopter
     * 
     * @param id adopter id
     * 
     * @return adopter id
     * @throws Exception
     */
    public AdopterModel getById(Long id) throws Exception {
        String model = getURL(id.toString());
        AdopterModel result = objectMapper.readValue(model, AdopterModel.class);
        return result;
    }

    /**
     * Method to get all adopters
     * 
     * @param urlPath url for the API of all adopters
     * 
     * @return all adopters
     * 
     * @throws Exception
     */
    public Collection<AdopterModel> getAll(String urlPath) throws Exception {
        List<AdopterModel> adopterList = null;
        try {
            String jsonString = getURL(urlPath);
            // Convert JSON string to List
            adopterList = objectMapper.readValue(jsonString, new TypeReference<List<AdopterModel>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adopterList;
    }

    /**
     * Method to delete adopter
     * 
     * @param id adopter id
     * 
     * @return if the adopter was deleted
     * 
     * @throws Exception
     */
    public boolean deleteById(Long id) throws Exception {
        return deleteObject(id);
    }

    /**
     * Method to save an adopter
     * 
     * @param adopterModel adopter model to save
     * 
     * @return adopter model
     * 
     * @throws Exception
     */
    public AdopterModel saveAdopter(AdopterModel adopterModel) throws Exception {
        try {
            String json = objectMapper.writeValueAsString(adopterModel);
            String result = saveObject(json);
            adopterModel = objectMapper.readValue(result, new TypeReference<AdopterModel>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adopterModel;
    }
}

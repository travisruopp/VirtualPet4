package org.wecancodeit.virtualpet4.Repositories;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.wecancodeit.virtualpet4.Models.PetMaintenanceModel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class PetMaintenanceRepository extends ClientHTTP{
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Parameterized constructor
     * 
     * @param baseURLString Base API URL
     */
    public PetMaintenanceRepository(String baseURLString) {
        super(baseURLString);
    }

    /**
     * Method to get the id of the pet maintenance
     * 
     * @param id pet maintenance id
     * 
     * @return pet maintenance id
     * @throws Exception
     */
    public PetMaintenanceModel getById(Long id) throws Exception {
        String model = getURL(id.toString());
        PetMaintenanceModel result = objectMapper.readValue(model, PetMaintenanceModel.class);
        return result;
    }

    /**
     * Method to get all pet maintenances
     * 
     * @param urlPath url for the API of all pet maintenances
     * 
     * @return all pet maintenances
     * 
     * @throws Exception
     */
    public Collection<PetMaintenanceModel> getAll(String urlPath) throws Exception {
        List<PetMaintenanceModel> petMaintenanceList = null;
        try {
            String jsonString = getURL(urlPath);
            // Convert JSON string to List
            petMaintenanceList = objectMapper.readValue(jsonString, new TypeReference<List<PetMaintenanceModel>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return petMaintenanceList;
    }

    /**
     * Method to delete pet maintenance
     * 
     * @param id pet maintenance id
     * 
     * @return if the pet maintenance was deleted
     * 
     * @throws Exception
     */
    public boolean deleteById(Long id) throws Exception {
        return deleteObject(id);
    }

    /**
     * Method to save an pet maintenance
     * 
     * @param petMaintenanceModel pet maintenance model to save
     * 
     * @return pet maintenance model
     * 
     * @throws Exception
     */
    public PetMaintenanceModel savePetMaintenance(PetMaintenanceModel petMaintenanceModel) throws Exception {
        try {
            String json = objectMapper.writeValueAsString(petMaintenanceModel);
            String result = saveObject(json);
            petMaintenanceModel = objectMapper.readValue(result, new TypeReference<PetMaintenanceModel>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return petMaintenanceModel;
    }
}

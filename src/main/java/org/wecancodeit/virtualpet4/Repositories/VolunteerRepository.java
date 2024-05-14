package org.wecancodeit.virtualpet4.Repositories;

import java.io.IOException;
import java.util.*;

import org.wecancodeit.virtualpet4.Models.VolunteerModel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VolunteerRepository extends ClientHTTP {

    private ObjectMapper objectMapper = new ObjectMapper();

    public VolunteerRepository(String baseURLString) {
        super(baseURLString);
    }

    public VolunteerModel getById(Long id) throws Exception {
        VolunteerModel result = new VolunteerModel();
        try {
            String model = getURL(id.toString());
            result = objectMapper.readValue(model, VolunteerModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Collection<VolunteerModel> getAll(String urlPath) throws Exception {
        List<VolunteerModel> volunteerList = null;
        try {
            String jsonString = getURL(urlPath);
            // Convert JSON string to List
            volunteerList = objectMapper.readValue(jsonString, new TypeReference<List<VolunteerModel>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return volunteerList;
    }

    public boolean deleteById(Long id) throws Exception {
        return deleteObject(id);
    }

    public VolunteerModel saveVolunteer(VolunteerModel volunteerModel) throws Exception {
        try {
            String json = objectMapper.writeValueAsString(volunteerModel);
            String result = saveObject(json);
            volunteerModel = objectMapper.readValue(result, new TypeReference<VolunteerModel>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return volunteerModel;
    }
}

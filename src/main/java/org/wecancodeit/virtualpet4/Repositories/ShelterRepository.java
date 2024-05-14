package org.wecancodeit.virtualpet4.Repositories;


import java.util.*;

import org.wecancodeit.virtualpet4.Dto.ShelterDto;
import org.wecancodeit.virtualpet4.Models.ShelterModel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShelterRepository extends ClientHTTP {

    private ObjectMapper objectMapper = new ObjectMapper();

    public ShelterRepository(String baseURLString) {
        super(baseURLString);
    }

    public ShelterModel getById(Long id) throws Exception {
        ShelterModel result = new ShelterModel();
        try {
            String model = getURL(id.toString());
            result = objectMapper.readValue(model, ShelterModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Collection<ShelterModel> getAll(String urlPath) throws Exception {
        List<ShelterModel> shelterList = null;
        try {
            String jsonString = getURL(urlPath);
            // Convert JSON string to List
            shelterList = objectMapper.readValue(jsonString, new TypeReference<List<ShelterModel>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shelterList;
    }

    public Collection<ShelterDto> getLookup() throws Exception{
        List<ShelterDto> shelterDtos = new ArrayList<>();
        try {
            String jsonString = getURL("shelterLookup");
            shelterDtos = objectMapper.readValue(jsonString, new TypeReference<List<ShelterDto>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shelterDtos;
        }

    public boolean deleteById(Long id) throws Exception {
        return deleteObject(id);
    }

    public ShelterModel saveShelter(ShelterModel shelterModel) throws Exception {
        try {
            String json = objectMapper.writeValueAsString(shelterModel);
            String result = saveObject(json);
            shelterModel = objectMapper.readValue(result, new TypeReference<ShelterModel>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shelterModel;
    }
}

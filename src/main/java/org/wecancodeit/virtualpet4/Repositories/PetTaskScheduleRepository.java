package org.wecancodeit.virtualpet4.Repositories;
import java.io.IOException;
import java.util.*;

import org.wecancodeit.virtualpet4.Models.PetTaskScheduleModel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class PetTaskScheduleRepository extends ClientHTTP{
    private ObjectMapper objectMapper = new ObjectMapper();

    public PetTaskScheduleRepository(String baseURLString) {
        super(baseURLString);
    }

    public PetTaskScheduleModel getByID(Long id) throws Exception{
        String model = getURL(id.toString());
        PetTaskScheduleModel result = objectMapper.readValue(model, PetTaskScheduleModel.class);
        return result;
    }

    public Collection<PetTaskScheduleModel> getAll(String urlPath) throws Exception {
        List<PetTaskScheduleModel> petTaskScheduleList = null;
        try {
            String jsonString = getURL(urlPath);
        //Convert JSON string to List
        petTaskScheduleList = objectMapper.readValue(jsonString, new TypeReference<List<PetTaskScheduleModel>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return petTaskScheduleList;
    }
}

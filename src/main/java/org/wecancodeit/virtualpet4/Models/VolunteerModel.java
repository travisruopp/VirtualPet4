package org.wecancodeit.virtualpet4.Models;

import java.util.Collection;

/**
 * Class that models the volunteer
 */
public class VolunteerModel extends ContactModel {

    private Collection<ShelterModel> shelterModels;

    /**
     * Default Constructor
     */
    public VolunteerModel() {
        super();
    }

    /**
     * Parameterized Constructor
     * 
     * @param name         volunteer's name
     * @param addressLine1 volunteer's address line 1
     * @param addressLine2 volunteer's address line 2
     * @param city         volunteer's city
     * @param state        volunteer's state (abbreviated)
     * @param zip          volunteer's zip code
     * @param phoneNumber  volunteer's phone number
     * @param email        volunteer's email
     * @param imageURL     volunteer's image url
     */
    public VolunteerModel(Long id, String name, String addressLine1, String addressLine2, String city, String state,
            String zip, String phoneNumber, String email, String imageURL) {
        super(id, name, addressLine1, addressLine2, city, state,
                zip, phoneNumber, email, imageURL);
    }
/**
     * Method to get the Shelter Models the Volunteer is in.
     * 
     * @return shelter models
     */
    public Collection<ShelterModel> getShelterModels() {
        return shelterModels;
    }
    /**
     * Method to set the shelter model for the volunteer
     * 
     * @param shelterModels shelter model
     */
    public void setShelterModel(Collection<ShelterModel> shelterModels){
        this.shelterModels = shelterModels;
    }
    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return super.toString() + "VolunteerModel []";
    }

}

package org.wecancodeit.virtualpet4.Dto;

import org.wecancodeit.virtualpet4.Models.ShelterModel;

/**
 * Class that models the pet shelter
 */
public class ShelterDto {

    private Long id;
    private String name;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;
    private String imageURL;
    private String shelterWebSite;

    /**
     * Default Constructor
     */
    public ShelterDto() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param id             shelter id
     * @param name           shelter name
     * @param addressLine1   shelter address line 1
     * @param addressLine2   shelter address line 2
     * @param city           shelter city
     * @param state          shelter state (abbreviated)
     * @param zip            shelter zip code
     * @param phoneNumber    shelter phone number
     * @param email          shelter email
     * @param imageURL       shelter image url
     * @param shelterWebSite shelter website
     */
    public ShelterDto(Long id, String name, String addressLine1, String addressLine2, String city, String state,
            String zip, String phoneNumber, String email, String imageURL, String shelterWebSite) {
        this.id = id;
        this.name = name;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.imageURL = imageURL;
        this.shelterWebSite = shelterWebSite;
    }

    /**
     * Method to get the shelter id
     * 
     * @return shelter id
     */
    public Long getId() {
        return id;
    }

    /**
     * method to set the shelter id
     * 
     * @param id shelter id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method to get shelter name
     * 
     * @return shelter name
     */
    public String getName() {
        return name;
    }

    /**
     * method to set the shelter name
     * 
     * @param name shelter name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the shelter Address Line 1
     * 
     * @return shelter address line 1
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Method to set the shelter address line 1
     * 
     * @param addressLine1 shelter address line 1
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * Method to set address line 2
     * 
     * @return address line 2
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Method to set shelter address line 2
     * 
     * @param addressLine2 shelter address line 2
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * Method to get shelter city
     * 
     * @return shelter city
     */
    public String getCity() {
        return city;
    }

    /**
     * Method to set the shelter city
     * 
     * @param city shelter city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Method to get shelter state
     * 
     * @return shelter state
     */
    public String getState() {
        return state;
    }

    /**
     * Method to set shelter state
     * 
     * @param state shelter state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Method to get shelter zip
     * 
     * @return shelter zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Method to set the shelter zip
     * 
     * @param zip shelter zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Method to get the shelter phone number
     * 
     * @return shelter phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method to set the shelter phone number
     * 
     * @param phoneNumber shelter phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method to get the shelter email
     * 
     * @return shelter email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method to set the shelter email
     * 
     * @param email shelter email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method to get the shelter image url
     * 
     * @return shelter image url
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Method to set the shelter image url
     * 
     * @param imageURL image url
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Method to get the shelter website
     * 
     * @return shelter website
     */
    public String getShelterWebSite() {
        return shelterWebSite;
    }

    /**
     * Method to set the shelter website
     * 
     * @param shelterWebSite shelter website
     */
    public void setShelterWebSite(String shelterWebSite) {
        this.shelterWebSite = shelterWebSite;
    }

    /**
     * Method to overload the shelter data transfer object parameterized constructor
     * 
     * @param model shelter model to migrate to a shelter data transfer object
     */
    public ShelterDto(ShelterModel model) {
        this.id = model.getId();
        this.name = model.getName();
        this.addressLine1 = model.getAddressLine1();
        this.addressLine2 = model.getAddressLine2();
        this.city = model.getCity();
        this.state = model.getState();
        this.zip = model.getZip();
        this.phoneNumber = model.getPhoneNumber();
        this.email = model.getEmail();
        this.imageURL = model.getImageURL();
        this.shelterWebSite = model.getShelterWebSite();
    }

    /**
     * Method to convert the shelter data transfer object to a shelter model
     * 
     * @return shelter model
     */
    public ShelterModel convertToModel() {
        if (id == null) {
            id = 0l;
        }
        ShelterModel shelter = new ShelterModel(this.getId(),
                this.getName(),
                this.getAddressLine1(),
                this.getAddressLine2(),
                this.getCity(),
                this.getState(),
                this.getZip(),
                this.getPhoneNumber(),
                this.getEmail(),
                this.getImageURL(),
                this.getShelterWebSite());
        return shelter;
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "ShelterDto [id=" + id + ", name=" + name + ", addressLine1=" + addressLine1 + ", addressLine2="
                + addressLine2 + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber
                + ", email=" + email + ", imageURL=" + imageURL + ", shelterWebSite=" + shelterWebSite + "]";
    }
}

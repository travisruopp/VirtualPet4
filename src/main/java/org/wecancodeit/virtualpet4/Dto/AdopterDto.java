package org.wecancodeit.virtualpet4.Dto;

import org.wecancodeit.virtualpet4.Models.AdopterModel;
import org.wecancodeit.virtualpet4.Models.ShelterModel;
import org.wecancodeit.virtualpet4.Models.Enums.AdoptionStatusEnum;
import org.wecancodeit.virtualpet4.Models.Enums.PetTypeEnum;

/**
 * Class that models the pet adopter
 */
public class AdopterDto {

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
    private PetTypeEnum preferredPetType;
    private AdoptionStatusEnum adoptionStatus;
    private String notes;
    private ShelterModel shelterModel;
    private long shelterId;

    /**
     * Default constructor
     */
    public AdopterDto() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param id               adopter id
     * @param name             adopter name
     * @param addressLine1     adopter address line 1
     * @param addressLine2     adopter address line 2
     * @param city             adopter city
     * @param state            adopter state (abbreviated)
     * @param zip              adopter zip
     * @param phoneNumber      adopter phone number US Only
     * @param email            adopter email
     * @param imageURL         adopter image URL
     * @param preferredPetType adopter preferred pet type
     * @param adoptionStatus   adopter adoption status
     * @param notes            adopter notes
     */
    public AdopterDto(Long id, String name, String addressLine1, String addressLine2, String city, String state,
            String zip, String phoneNumber, String email, String imageURL, PetTypeEnum preferredPetType,
            AdoptionStatusEnum adoptionStatus, String notes) {
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
        this.preferredPetType = preferredPetType;
        this.adoptionStatus = adoptionStatus;
        this.notes = notes;
    }

    /**
     * Method to get the adopter id
     * 
     * @return adopter id
     */
    public Long getId() {
        return id;
    }

    /**
     * method to set the adopter id
     * 
     * @param id adopter id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method to get adopter name
     * 
     * @return adopter name
     */
    public String getName() {
        return name;
    }

    /**
     * method to set the adopter name
     * 
     * @param name adopter name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the adopter Address Line 1
     * 
     * @return adopter address line 1
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Method to set the adopter address line 1
     * 
     * @param addressLine1 adopter address line 1
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
     * Method to set adopter address line 2
     * 
     * @param addressLine2 adopter address line 2
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * Method to get adopter city
     * 
     * @return adopter city
     */
    public String getCity() {
        return city;
    }

    /**
     * Method to set the adopter city
     * 
     * @param city adopter city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Method to get adopter state
     * 
     * @return adopter state
     */
    public String getState() {
        return state;
    }

    /**
     * Method to set adopter state
     * 
     * @param state adopter state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Method to get adopter zip
     * 
     * @return adopter zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Method to set the adopter zip
     * 
     * @param zip adopter zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Method to get the adopter phone number
     * 
     * @return adopter phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method to set the adopter phone number
     * 
     * @param phoneNumber adopter phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method to get the adopter email
     * 
     * @return adopter email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method to set the adopter email
     * 
     * @param email adopter email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method to get the adopter image url
     * 
     * @return adopter image url
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Method to set the adopter image url
     * 
     * @param imageURL image url
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Method to get the adopter preferred pet type
     * 
     * @return adopter preferred pet type
     */
    public PetTypeEnum getPreferredPetType() {
        return preferredPetType;
    }

    /**
     * Method to set the adopter preferred pet type
     * 
     * @param preferredPetType adopter preferred pet type
     */
    public void setPreferredPetType(PetTypeEnum preferredPetType) {
        this.preferredPetType = preferredPetType;
    }

    /**
     * Method to get the adopter adoptions status
     * 
     * @return adopter adoption status
     */
    public AdoptionStatusEnum getAdoptionStatus() {
        return adoptionStatus;
    }

    /**
     * Method to set the adopter adoption status
     * 
     * @param adoptionStatus adopter adoption status
     */
    public void setAdoptionStatus(AdoptionStatusEnum adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    /**
     * Method to get adopter notes
     * 
     * @return adopter notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Method to set the adopter notes
     * 
     * @param notes adopter notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getShelterId() {
        return shelterId;
    }

    public void setShelterId(long shelterId) {
        this.shelterId = shelterId;
    }

    /**
     * Method to overload the adopter data transfer object parameterized constructor
     * 
     * @param model adopter model to migrate to a adopter data transfer object
     */
    public AdopterDto(AdopterModel model) {
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
        this.preferredPetType = model.getPreferredPetType();
        this.adoptionStatus = model.getAdoptionStatus();
        this.notes = model.getNotes();
        if (model.getShelterModel() != null) {
            this.shelterModel = model.getShelterModel();
            this.shelterId = this.shelterModel.getId();
        }
    }

    /**
     * Method to convert the adopter data transfer object to a adopter model
     * 
     * @return adopter model
     */
    public AdopterModel convertToModel() {
        if (id == null) {
            id = 0l;
        }
        AdopterModel adopter = new AdopterModel(this.getId(),
                this.getName(),
                this.getAddressLine1(),
                this.getAddressLine2(),
                this.getCity(),
                this.getState(),
                this.getZip(),
                this.getPhoneNumber(),
                this.getEmail(),
                this.getImageURL(),
                this.getPreferredPetType(),
                this.getAdoptionStatus(),
                this.getNotes());
            adopter.setShelterModel(this.shelterModel);
        return adopter;
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "AdopterDto [id=" + id + ", name=" + name + ", addressLine1=" + addressLine1 + ", addressLine2="
                + addressLine2 + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber
                + ", email=" + email + ", imageURL=" + imageURL + ", preferredPetType=" + preferredPetType
                + ", adoptionStatus=" + adoptionStatus + ", notes=" + notes + ", shelterModel=" + shelterModel
                + ", shelterId=" + shelterId + ", getClass()=" + getClass() + ", getId()=" + getId() + ", getName()="
                + getName() + ", getAddressLine1()=" + getAddressLine1() + ", getAddressLine2()=" + getAddressLine2()
                + ", getCity()=" + getCity() + ", hashCode()=" + hashCode() + ", getState()=" + getState()
                + ", getZip()=" + getZip() + ", getPhoneNumber()=" + getPhoneNumber() + ", getEmail()=" + getEmail()
                + ", getImageURL()=" + getImageURL() + ", getPreferredPetType()=" + getPreferredPetType()
                + ", getAdoptionStatus()=" + getAdoptionStatus() + ", getNotes()=" + getNotes() + ", getShelterId()="
                + getShelterId() + ", convertToModel()=" + convertToModel() + ", toString()=" + super.toString() + "]";
    }
}

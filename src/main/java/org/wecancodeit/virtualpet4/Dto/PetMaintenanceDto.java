package org.wecancodeit.virtualpet4.Dto;

import org.wecancodeit.virtualpet4.Models.PetMaintenanceModel;
import org.wecancodeit.virtualpet4.Models.Enums.*;

public class PetMaintenanceDto {
    private Long id;
    private String name;
    private int frequency;
    private PetTypeEnum petType;
    private PetTaskEnum effectedProperty;

    /**
     * Default Constructor
     */
    public PetMaintenanceDto() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param name             pet maintenance name
     * @param frequency        pet maintenance frequency required
     * @param petType          pet maintenance type of pet
     * @param effectedProperty effected property of pet
     */
    public PetMaintenanceDto(Long id, String name, int frequency, PetTypeEnum petType,
            PetTaskEnum effectedProperty) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
        this.petType = petType;
        this.effectedProperty = effectedProperty;
    }

    /**
     * Method to get the pet maintenance id
     * 
     * @return pet maintenance id
     */
    public Long getId() {
        return id;
    }

    /**
     * Method to set the pet maintenance id
     * 
     * @param id pet maintenance id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Method to get the pet maintenance name
     * 
     * @return pet maintenance name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the pet maintenance name
     * 
     * @param name pet maintenance name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to the pet maintenance frequency
     * 
     * @return pet maintenance frequency
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Method to set the pet maintenance frequency
     * 
     * @param frequency pet maintenance frequency
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     * Method to get the pet maintenance pet type
     * 
     * @return pet maintenance pet type
     */
    public PetTypeEnum getPetType() {
        return petType;
    }

    /**
     * Method to set the pet maintenance pet type
     * 
     * @param petType pet maintenance pet type
     */
    public void setPetType(PetTypeEnum petType) {
        this.petType = petType;
    }

    /**
     * Method to get the pet maintenance effected property
     * 
     * @return pet maintenance effected property
     */
    public PetTaskEnum getEffectedProperty() {
        return effectedProperty;
    }

    /**
     * Method to set the pet maintenance effected property
     * 
     * @param effectedProperty pet maintenance effected property
     */
    public void setEffectedProperty(PetTaskEnum effectedProperty) {
        this.effectedProperty = effectedProperty;
    }

    /**
     * Method to overload the pet maintenance data transfer object parameterized constructor
     * 
     * @param model pet maintenance model to migrate to a pet maintenance data transfer object
     */
    public PetMaintenanceDto (PetMaintenanceModel model){
        this.id = model.getId();
        this.name = model.getName();
        this.frequency = model.getFrequency();
        this.petType = model.getPetType();
        this.effectedProperty = model.getEffectedProperty();
    }
    

    /**
     * Method to convert the pet maintenance data transfer object to a pet maintenance model
     * 
     * @return pet maintenance model
     */
    public PetMaintenanceModel convertToModel(){
        if (id == null) {
            id = 0l;
        }
        PetMaintenanceModel petMaintenanceModel = new PetMaintenanceModel(this.getId(),
        this.getName(),
        this.getFrequency(),
        this.getPetType(),
        this.getEffectedProperty());
        return petMaintenanceModel;
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "PetMaintenanceDto [id=" + id + ", name=" + name + ", frequency=" + frequency + ", petType=" + petType
                + ", effectedProperty=" + effectedProperty + "]";
    }
    
    
}

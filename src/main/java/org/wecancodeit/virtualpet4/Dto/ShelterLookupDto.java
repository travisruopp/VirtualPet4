package org.wecancodeit.virtualpet4.Dto;

public class ShelterLookupDto {
    private String name;
    private Long id;
    public ShelterLookupDto() {
    }
    public ShelterLookupDto(String name, long id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    
}


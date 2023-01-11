package managepeople.applicationws.controller.dto.request;

import java.sql.Date;

public class PeopleRequestDTO {

    private String name;
    private Date birthDate;
    private AddressRequestDTO address;

    public PeopleRequestDTO(String name, Date birthDate, AddressRequestDTO address) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public AddressRequestDTO getAddress() {
        return address;
    }

    public void setAddress(AddressRequestDTO address) {
        this.address = address;
    }
}

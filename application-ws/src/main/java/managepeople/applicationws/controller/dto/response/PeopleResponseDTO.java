package managepeople.applicationws.controller.dto.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeopleResponseDTO {

    private Long idPeople;
    private String name;
    private Date birthDate;
    private List<AddressResponseDTO> address;

    public PeopleResponseDTO(Long idPeople, String name, Date birthDate) {
        this.idPeople = idPeople;
        this.name = name;
        this.birthDate = birthDate;
        this.address = new ArrayList<>();
    }

    public PeopleResponseDTO(Long idPeople, String name, Date birthDate, List<AddressResponseDTO> address) {
        this.idPeople = idPeople;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }

    public Long getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(Long idPeople) {
        this.idPeople = idPeople;
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

    public List<AddressResponseDTO> getAddress() {
        return address;
    }

    public void setAddress(List<AddressResponseDTO> address) {
        this.address = address;
    }
}

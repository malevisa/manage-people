package managepeople.applicationws.domain;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeople;

    private String name;
    private Date birthDate;

    public People(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public People() {
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
}

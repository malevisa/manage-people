package managepeople.applicationws.controller.dto.request;

public class AddressRequestDTO {

    private String logradouro;
    private String cep;
    private Integer number;
    private String city;

    public AddressRequestDTO(String logradouro, String cep, Integer number, String city) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.number = number;
        this.city = city;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

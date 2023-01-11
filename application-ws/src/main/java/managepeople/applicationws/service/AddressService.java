package managepeople.applicationws.service;

import managepeople.applicationws.controller.dto.request.AddressRequestDTO;
import managepeople.applicationws.controller.dto.response.AddressResponseDTO;
import managepeople.applicationws.domain.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Optional<AddressResponseDTO> createAddress(Long idPeople, AddressRequestDTO addressRequest);

    List<AddressResponseDTO> getAddressFromPeople(Long idPeople);

    Optional<Address> setMainAddress(Long idAddress);
}

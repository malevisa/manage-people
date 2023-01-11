package managepeople.applicationws.service.impl;

import managepeople.applicationws.controller.dto.request.AddressRequestDTO;
import managepeople.applicationws.controller.dto.response.AddressResponseDTO;
import managepeople.applicationws.domain.Address;
import managepeople.applicationws.domain.People;
import managepeople.applicationws.repository.AddressRepository;
import managepeople.applicationws.repository.PeopleRepository;
import managepeople.applicationws.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Optional<AddressResponseDTO> createAddress(Long idPeople, AddressRequestDTO addressRequest) {

        Optional<People> people = peopleRepository.findById(idPeople);

        if (people.isPresent()) {

            Address address = addressRepository.save(
                    new Address(
                            people.get(),
                            addressRequest.getLogradouro(),
                            addressRequest.getCep(),
                            addressRequest.getNumber(),
                            addressRequest.getCity()
                    )
            );

            return Optional.of(buildAddressDTO(address));

        }

        return Optional.empty();
    }

    @Override
    public List<AddressResponseDTO> getAddressFromPeople(Long idPeople) {

        List<Address> addressList = addressRepository.findByPeopleIdPeople(idPeople);
        List<AddressResponseDTO> addressResponseList = new ArrayList<>();

        if (!addressList.isEmpty()) {
            for (Address address : addressList) {

                addressResponseList.add(
                        buildAddressDTO(address)
                );

            }
        }

        return addressResponseList;
    }

    @Override
    public Optional<Address> setMainAddress(Long idAddress) {

        Optional<Address> addressOptional = addressRepository.findById(idAddress);

        if (addressOptional.isPresent()) {

            Address address = addressOptional.get();

            address.setPrincipal(true);

            addressRepository.save(address);

        }

        return addressOptional;
    }

    private AddressResponseDTO buildAddressDTO(Address address) {
        return new AddressResponseDTO(
                address.getId(),
                address.getLogradouro(),
                address.getCep(),
                address.getNumber(),
                address.getCity()
        );
    }
}

package managepeople.applicationws.service.impl;

import managepeople.applicationws.controller.dto.request.EditPeopleRequestDTO;
import managepeople.applicationws.controller.dto.request.PeopleRequestDTO;
import managepeople.applicationws.controller.dto.response.AddressResponseDTO;
import managepeople.applicationws.controller.dto.response.PeopleResponseDTO;
import managepeople.applicationws.domain.Address;
import managepeople.applicationws.domain.People;
import managepeople.applicationws.repository.AddressRepository;
import managepeople.applicationws.repository.PeopleRepository;
import managepeople.applicationws.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public PeopleResponseDTO createPeople(PeopleRequestDTO peopleRequest) {

        List<AddressResponseDTO> addressList = new ArrayList<>();
        People people = peopleRepository.save(
                new People(
                        peopleRequest.getName(),
                        peopleRequest.getBirthDate()
                )
        );

        Address address = addressRepository.save(
                new Address(
                        people,
                        peopleRequest.getAddress().getLogradouro(),
                        peopleRequest.getAddress().getCep(),
                        peopleRequest.getAddress().getNumber(),
                        peopleRequest.getAddress().getCity()
                )
        );

        addressList.add(
                buildAddressDTO(address)
        );

        return buildPeopleResponseDTO(people, addressList);
    }

    @Override
    public Optional<People> editPeople(Long idPeople, EditPeopleRequestDTO peopleRequest) {

        Optional<People> people = peopleRepository.findById(idPeople);

        if (people.isPresent()) {
            People foundPeople = people.get();

            foundPeople.setName(peopleRequest.getName());
            foundPeople.setBirthDate(peopleRequest.getBirthDate());

            peopleRepository.save(foundPeople);

        }
        return people;
    }

    @Override
    public Optional<PeopleResponseDTO> findPeople(Long idPeople) {

        Optional<People> people = peopleRepository.findById(idPeople);
        List<AddressResponseDTO> addressResponseDTOList = new ArrayList<>();

        if (people.isPresent()) {

            List<Address> addressListOptional = addressRepository.findByPeopleIdPeople(people.get().getIdPeople());

            if (!addressListOptional.isEmpty()) {

                for (Address address : addressListOptional) {
                    addressResponseDTOList.add(
                            buildAddressDTO(address)
                    );
                }

            }

            return Optional.of(
                    buildPeopleResponseDTO(people.get(), addressResponseDTOList)
            );

        }

        return Optional.empty();
    }

    @Override
    public List<PeopleResponseDTO> getPeoples() {
        List<People> peopleList = peopleRepository.findAll();
        List<PeopleResponseDTO> peopleResponseDTOList = new ArrayList<>();
        List<AddressResponseDTO> addressResponseDTOList;

        for (People people : peopleList) {

            addressResponseDTOList = new ArrayList<>();

            List<Address> addressList = addressRepository.findByPeopleIdPeople(people.getIdPeople());

            for (Address address : addressList) {
                addressResponseDTOList.add(
                        buildAddressDTO(address)
                );
            }

            peopleResponseDTOList.add(
                    buildPeopleResponseDTO(people, addressResponseDTOList)
            );

        }

        return peopleResponseDTOList;
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

    public PeopleResponseDTO buildPeopleResponseDTO(People people, List<AddressResponseDTO> addressList) {
        return new PeopleResponseDTO(
                people.getIdPeople(),
                people.getName(),
                people.getBirthDate(),
                addressList
        );
    }
}

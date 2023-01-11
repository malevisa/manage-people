package managepeople.applicationws.service;

import managepeople.applicationws.controller.dto.request.EditPeopleRequestDTO;
import managepeople.applicationws.controller.dto.request.PeopleRequestDTO;
import managepeople.applicationws.controller.dto.response.PeopleResponseDTO;
import managepeople.applicationws.domain.People;

import java.util.List;
import java.util.Optional;

public interface PeopleService {

    PeopleResponseDTO createPeople(PeopleRequestDTO peopleRequest);

    Optional<People> editPeople(Long idPeople, EditPeopleRequestDTO peopleRequest);

    Optional<PeopleResponseDTO> findPeople(Long idPeople);

    List<PeopleResponseDTO> getPeoples();
}

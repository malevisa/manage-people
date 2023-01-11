package managepeople.applicationws.controller;

import managepeople.applicationws.controller.dto.request.EditPeopleRequestDTO;
import managepeople.applicationws.controller.dto.request.PeopleRequestDTO;
import managepeople.applicationws.controller.dto.response.PeopleResponseDTO;
import managepeople.applicationws.domain.People;
import managepeople.applicationws.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @PostMapping("/create-people")
    public ResponseEntity<PeopleResponseDTO> createPeople(@RequestBody PeopleRequestDTO peopleRequest) {

        return ResponseEntity.status(201).body(
                peopleService.createPeople(peopleRequest)
        );
    }

    @PutMapping("/edit-people/{idPeople}")
    public ResponseEntity editPeople(@PathVariable Long idPeople, @RequestBody EditPeopleRequestDTO peopleRequest) {

        Optional<People> people = peopleService.editPeople(idPeople, peopleRequest);

        if (people.isPresent()) {
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();

    }

    @GetMapping("/find-people/{idPeople}")
    public ResponseEntity<PeopleResponseDTO> findPeople(@PathVariable Long idPeople) {

        Optional<PeopleResponseDTO> people = peopleService.findPeople(idPeople);

        if (people.isPresent()) {

            return ResponseEntity.status(200).body(people.get());

        }

        return ResponseEntity.status(404).build();

    }

    @GetMapping("/get-peoples")
    public ResponseEntity<List<PeopleResponseDTO>> getPeoples() {

        List<PeopleResponseDTO> peopleList = peopleService.getPeoples();

        if (peopleList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(peopleList);

    }

}

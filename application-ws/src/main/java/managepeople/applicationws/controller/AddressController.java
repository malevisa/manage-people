package managepeople.applicationws.controller;

import managepeople.applicationws.controller.dto.request.AddressRequestDTO;
import managepeople.applicationws.controller.dto.response.AddressResponseDTO;
import managepeople.applicationws.domain.Address;
import managepeople.applicationws.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/create-address/{idPeople}")
    public ResponseEntity<AddressResponseDTO> createAddress(@PathVariable Long idPeople, @RequestBody AddressRequestDTO addressRequest) {

        Optional<AddressResponseDTO> address = addressService.createAddress(idPeople, addressRequest);

        if (address.isPresent()) {
            return ResponseEntity.status(201).body(address.get());
        }

        return ResponseEntity.status(404).build();

    }

    @GetMapping("/get-address-of-people/{idPeople}")
    public ResponseEntity<List<AddressResponseDTO>> getAddressOfPeople(@PathVariable Long idPeople) {

        List<AddressResponseDTO> addressList = addressService.getAddressFromPeople(idPeople);

        if (addressList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(addressList);

    }

    @PutMapping("/set-main-address/{idAddress}")
    public ResponseEntity setMainAddress(@PathVariable Long idAddress) {

        Optional<Address> address = addressService.setMainAddress(idAddress);

        if (address.isPresent()) {
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

}

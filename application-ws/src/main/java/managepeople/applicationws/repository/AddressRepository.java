package managepeople.applicationws.repository;

import managepeople.applicationws.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
   List<Address> findByPeopleIdPeople(Long idPeople);
}

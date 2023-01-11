package managepeople.applicationws.repository;

import managepeople.applicationws.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {



}

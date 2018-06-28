package ro.siit.java10.evproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.siit.java10.evproject.domain.Dealership;
import javax.transaction.Transactional;

@Repository
@Transactional

/**
 * Spring Data JPA repository for the Dealership entity.
 */

public interface DealershipDAO extends JpaRepository<Dealership, Long> {

//    @Query("SELECT e FROM dealership e WHERE e.name LIKE ?1")
//     List<Dealership> findByName(String dealershipName);

//    List<Dealership> findByNameAndAddress(String dealershipName, String dealershipAddress);
// Page<Dealership> findByNameContaining(String dealershipName, Pageable pageable);
 //userRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
}

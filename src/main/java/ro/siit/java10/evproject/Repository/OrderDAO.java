package ro.siit.java10.evproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.siit.java10.evproject.domain.Order;

import javax.transaction.Transactional;

/**
 * Spring Data JPA repository for the Order entity.
 */

@Repository
@Transactional
public interface OrderDAO extends JpaRepository <Order, Long> {
}

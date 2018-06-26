package ro.siit.java10.evproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.siit.java10.evproject.domain.Vehicles;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VehicleDAO extends JpaRepository<Vehicles, Long>{
}

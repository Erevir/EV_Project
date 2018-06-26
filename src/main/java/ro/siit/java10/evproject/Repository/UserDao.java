package ro.siit.java10.evproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.siit.java10.evproject.domain.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserDao extends JpaRepository<User, Long> {

//    @Query("select u from #{#entityName} u where u.lastname = ?1")
//    Optional<User> findByLastname();

}

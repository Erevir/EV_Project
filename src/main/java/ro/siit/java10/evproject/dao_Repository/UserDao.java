package ro.siit.java10.evproject.dao_Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.siit.java10.evproject.domain.User;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface UserDao extends JpaRepository{

}

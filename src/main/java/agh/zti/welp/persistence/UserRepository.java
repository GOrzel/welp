package agh.zti.welp.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User getUserById(long id);
    boolean existsUserByLogin(String login);
    User getUserByLogin(String login);
    ArrayList<User> findAll();
    void deleteById(long id);

}

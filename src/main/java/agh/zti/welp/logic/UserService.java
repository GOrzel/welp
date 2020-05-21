package agh.zti.welp.logic;

import agh.zti.welp.controllers.presentations.UserPresentation;
import agh.zti.welp.persistence.User;
import agh.zti.welp.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserPresentation getUserById(long id) {
        return new UserPresentation(userRepository.getUserById(id));
    }

    public boolean checkIfExist(String login){
        return userRepository.existsUserByLogin(login);
    }

    public ArrayList<UserPresentation> getAllUsers() {
        ArrayList<UserPresentation> result = new ArrayList<>();

        userRepository.findAll().forEach(a -> {
            result.add(new UserPresentation(a));
        });
        return result;
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    public UserPresentation addUser(String login) {
        return new UserPresentation(userRepository.save(new User(login)));
    }

    public User getUserByLogin(String login){
        return userRepository.getUserByLogin(login);
    }

}

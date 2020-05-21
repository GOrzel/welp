package agh.zti.welp.controllers;

import agh.zti.welp.controllers.presentations.UserPresentation;
import agh.zti.welp.logic.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("rest/user")
public class UserController {

    private UserService userService;
    private static Logger LOG = LoggerFactory.getLogger(UserController.class);


    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserPresentation getUser(@PathVariable("id") long id){
        LOG.debug("Executing getUser with id: " + id);
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public boolean checkIfExist(@RequestParam String login){
        LOG.debug("Executing checkIfExist with login: " + login);
        return userService.checkIfExist(login);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<UserPresentation> getAllUsers(){
        LOG.debug("Executing getAll");
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") long id){
        LOG.debug("Executing deleteUser with id: " + id);
        userService.deleteUserById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public UserPresentation addUser(@RequestBody String login){
        LOG.debug("Executing createUser with name: " + login);
        return userService.addUser(login);
    }


}

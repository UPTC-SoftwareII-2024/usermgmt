package edu.uptc.swii.usermgmt.rest;

import org.springframework.web.bind.annotation.RestController;

import edu.uptc.swii.usermgmt.domain.User;
import edu.uptc.swii.usermgmt.service.UserMgmtService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/users")
@RefreshScope
public class UserMgmtEndpoint {
    @Autowired
    private UserMgmtService userMgmtService;

    @Value("${message}")
    private String message;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String welcome() {
        return message;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    public User findByUserId(@PathVariable("userId") String userId) {
        User user = userMgmtService.findByUserId(userId);
        return user;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
    public String createUser(@RequestBody User user) {
        userMgmtService.saveUser(user);
        return "userId: " + user.getId();
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET, produces = "application/json")
    public List<User> listUsers() {
        return userMgmtService.listAllUsers();
    }
}


// Prueba de avances
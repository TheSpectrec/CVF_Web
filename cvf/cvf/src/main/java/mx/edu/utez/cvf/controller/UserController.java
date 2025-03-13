package mx.edu.utez.cvf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.cvf.entity.User;
import mx.edu.utez.cvf.serviceImpl.HouseServiceImpl;
import mx.edu.utez.cvf.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private UserServiceImpl serviceImpl;

    @Autowired
    private HouseServiceImpl houseServiceImpl;

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return serviceImpl.listUsers();
    }

    @GetMapping("/findById/{user_id}")
    public User fUserById(@PathVariable String user_id) {
        return serviceImpl.findById(user_id);
    }

    @PostMapping("/save")
    public Boolean saveUser(@RequestBody User user) {
        System.out.println(user.toString());
        return serviceImpl.saveUser(user);
    }

    @PutMapping("/update")
    public Boolean updateUser(@RequestBody User user) {
        return serviceImpl.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteUser(@PathVariable String id) {
        return serviceImpl.deleteUser(id);
    }
}

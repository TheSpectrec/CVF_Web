package mx.edu.utez.cvf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mx.edu.utez.cvf.entity.User;
import mx.edu.utez.cvf.serviceImpl.HouseServiceImpl;
import mx.edu.utez.cvf.serviceImpl.UserServiceImpl;
@CrossOrigin(origins = "http://localhost:5173") // Permite solicitudes desde el frontend

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

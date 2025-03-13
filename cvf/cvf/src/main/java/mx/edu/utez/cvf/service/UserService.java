package mx.edu.utez.cvf.service;

import java.util.List;

import mx.edu.utez.cvf.entity.User;

public interface UserService {

    List<User> listUsers();

    User findById(String id);

    Boolean saveUser(User user);

    Boolean updateUser(User user);

    Boolean deleteUser(String id);
}

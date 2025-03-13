package mx.edu.utez.cvf.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.cvf.entity.User;
import mx.edu.utez.cvf.repository.UserRepository;
import mx.edu.utez.cvf.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public Boolean saveUser(User user) {
        boolean response = false;
        User userSaved = userRepository.save(user);
        if (userSaved != null) {
            response = true;
        }
        return response;
    }

    @Override
    public Boolean updateUser(User user) {
        boolean response = false;
        User userSaved = userRepository.save(user);
        if (userSaved != null) {
            response = true;
        }
        return response;
    }

    @Override
    public Boolean deleteUser(String id) {
        Boolean response = false;
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            response = true;
        }
        return response;
    }

}

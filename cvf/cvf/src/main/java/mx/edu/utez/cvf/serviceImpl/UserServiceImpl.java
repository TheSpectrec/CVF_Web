package mx.edu.utez.cvf.serviceImpl;

import mx.edu.utez.cvf.entity.Rol;
import mx.edu.utez.cvf.entity.User;
import mx.edu.utez.cvf.repository.RolRepository;
import mx.edu.utez.cvf.repository.UserRepository;
import mx.edu.utez.cvf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    // Obtener todos los usuarios
    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    // Buscar usuario por ID
    @Override
    public User findById(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    // Guardar o actualizar usuario con rol asociado
    @Override
    public Boolean saveUser(User user) {
        if (!user.getRols().isEmpty()) {
            String nombreRol = user.getRols().iterator().next().getName();
            Rol rol = rolRepository.findById(nombreRol).orElse(null);
            if (rol != null) {
                user.setRols(Set.of(rol));
            } else {
                System.out.println("⚠️ Rol no encontrado: " + nombreRol);
                return false;
            }
        }

        // Activar por defecto si es nuevo
        if (user.getEnabled() == null) {
            user.setEnabled(true);
        }

        return userRepository.save(user) != null;
    }

    // Eliminar lógicamente (desactivar usuario)
    @Override
    public Boolean deleteUser(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEnabled(false);
            userRepository.save(user);
            return true;
        }
        return false;
    }
}

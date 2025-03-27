package mx.edu.utez.cvf.service;

import mx.edu.utez.cvf.entity.User;
import java.util.List;

public interface UserService {

    // Obtener todos los usuarios
    List<User> listUsers();

    // Buscar usuario por ID
    User findById(String id);

    // Guardar o actualizar un usuario
    Boolean saveUser(User user);

    // Eliminar lógicamente (desactivar)
    Boolean deleteUser(String id); // usado para desactivación

    // Si prefieres claridad, puedes declarar también este alias:
    // Boolean disableUser(String id);
}

package mx.edu.utez.cvf.service;

import java.util.List;

import mx.edu.utez.cvf.entity.Rol;

public interface RolService {

    List<Rol> listRoles();

    Rol findById(String id);

    Boolean saveRol(Rol rol);

    Boolean updateRol(Rol rol);

    Boolean deleteRol(String id);
}

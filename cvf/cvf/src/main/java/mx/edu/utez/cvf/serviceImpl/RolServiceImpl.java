package mx.edu.utez.cvf.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.cvf.entity.Rol;
import mx.edu.utez.cvf.repository.RolRepository;
import mx.edu.utez.cvf.service.RolService;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> listRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol findById(String id) {
        Optional<Rol> rol = rolRepository.findById(id);
        if (rol.isPresent()) {
            return rol.get();
        }
        return null;
    }

    @Override
    public Boolean saveRol(Rol rol) {
        boolean response = false;
        Rol rolSaved = rolRepository.save(rol);
        if (rolSaved != null) {
            response = true;
        }
        return response;
    }

    @Override
    public Boolean updateRol(Rol rol) {
        boolean response = false;
        Rol rolUpdate = rolRepository.save(rol);
        if (rolUpdate != null) {
            response = true;
        }
        return response;
    }

    @Override
    public Boolean deleteRol(String id) {
        Boolean response = false;
        if (rolRepository.findById(id).isPresent()) {
            rolRepository.deleteById(id);
            response = true;
        }
        return response;
    }

}

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
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.cvf.entity.Rol;
import mx.edu.utez.cvf.serviceImpl.RolServiceImpl;

@RestController
@RequestMapping(value = "/api/v1/roles")
public class RolController {

    @Autowired
    private RolServiceImpl serviceImpl;

    @GetMapping("/list")
    public List<Rol> getAllRoles() {
        return serviceImpl.listRoles();
    }

    @GetMapping("/findById/{rol_id}")
    public Rol findRolById(@PathVariable String rol_id) {
        return serviceImpl.findById(rol_id);
    }

    @PostMapping("/save")
    public Boolean saveRol(@RequestBody Rol rol) {
        return serviceImpl.saveRol(rol);
    }

    @PutMapping("/update")
    public Boolean updateRol(@RequestBody Rol rol) {
        return serviceImpl.saveRol(rol);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteRol(@PathVariable String id) {
        return serviceImpl.deleteRol(id);
    }
}

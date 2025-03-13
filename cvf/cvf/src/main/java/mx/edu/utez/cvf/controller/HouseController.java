package mx.edu.utez.cvf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.cvf.entity.House;
import mx.edu.utez.cvf.serviceImpl.HouseServiceImpl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/api/v1/houses")
public class HouseController {

    @Autowired
    private HouseServiceImpl serviceImpl;

    @GetMapping("/list")
    public List<House> getAllHouses() {
        return serviceImpl.listHouses();
    }

    @GetMapping("/findById/{house_id}")
    public House findHouseById(@PathVariable Long house_id) {
        return serviceImpl.findById(house_id);
    }

    @PostMapping("/save")
    public Boolean saveHouse(@RequestBody House house) {
        return serviceImpl.saveHouse(house);
    }

    @PutMapping("/update")
    public Boolean updateHouse(@RequestBody House house) {
        return serviceImpl.saveHouse(house);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteHouse(@PathVariable Long id) {
        return serviceImpl.deleteHouse(id);
    }
}

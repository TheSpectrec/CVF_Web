package mx.edu.utez.cvf.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.cvf.entity.House;
import mx.edu.utez.cvf.repository.HouseRepository;
import mx.edu.utez.cvf.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public List<House> listHouses() {
        return houseRepository.findAll();
    }

    @Override
    public House findById(Long house_id) {
        Optional<House> house = houseRepository.findById(house_id);
        if (house.isPresent()) {
            return house.get();
        }
        return null;
    }

    @Override
    public Boolean saveHouse(House house) {
        Boolean response = false;
        House houseSaved = houseRepository.save(house);
        if (houseSaved != null) {
            response = true;
        }
        return response;
    }

    @Override
    public Boolean updateHouse(House house) {
        Boolean response = false;
        House updateHouse = houseRepository.save(house);
        if (updateHouse != null) {
            response = true;
        }
        return response;
    }

    @Override
    public Boolean deleteHouse(Long id) {
        Boolean response = false;
        if (houseRepository.findById(id).isPresent()) {
            houseRepository.deleteById(id);
            response = true;
        }
        return response;
    }
}

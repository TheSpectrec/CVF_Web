package mx.edu.utez.cvf.service;

import java.util.List;

import mx.edu.utez.cvf.entity.House;

public interface HouseService {

    List<House> listHouses();

    House findById(Long id);

    Boolean saveHouse(House house);

    Boolean updateHouse(House house);

    Boolean deleteHouse(Long id);
}

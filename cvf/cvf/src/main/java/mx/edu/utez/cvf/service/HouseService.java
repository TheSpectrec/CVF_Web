package mx.edu.utez.cvf.service;

import mx.edu.utez.cvf.entity.House;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface HouseService {

    List<House> listHouses();

    Optional<House> findById(Long id);

    Boolean saveHouse(House house);

    Boolean updateHouse(House house);

    Boolean deleteHouse(Long id);

    boolean saveHouse(String adress, String description, String preferences, boolean enabled, MultipartFile file);

    boolean updateHouse(Long id, String adress, String description, String preferences, boolean enabled, MultipartFile file);
}

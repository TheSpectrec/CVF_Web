package mx.edu.utez.cvf.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public Optional<House> findById(Long id) {
        return houseRepository.findById(id);
    }

    @Override
    public Boolean saveHouse(House house) {
        House saved = houseRepository.save(house);
        return saved != null;
    }

    @Override
    public Boolean updateHouse(House house) {
        House updated = houseRepository.save(house);
        return updated != null;
    }

    @Override
    public Boolean deleteHouse(Long id) {
        Optional<House> houseOptional = houseRepository.findById(id);
        if (houseOptional.isPresent()) {
            House house = houseOptional.get();
            house.setEnabled(false); // Eliminación lógica
            houseRepository.save(house);
            return true;
        }
        return false;
    }

    @Override
    public boolean saveHouse(String adress, String description, String preferences, boolean enabled, MultipartFile file) {
        try {
            House house = new House();
            house.setAdress(adress);
            house.setDescription(description);
            house.setPreferences(preferences);
            house.setEnabled(enabled);

            if (file != null && !file.isEmpty()) {
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                String uploadDir = "uploads/";
                Path path = Paths.get(uploadDir + fileName);
                Files.createDirectories(path.getParent());
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                house.setPhoto(fileName);
            }

            houseRepository.save(house);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateHouse(Long id, String adress, String description, String preferences, boolean enabled, MultipartFile file) {
        Optional<House> optionalHouse = houseRepository.findById(id);
        if (optionalHouse.isPresent()) {
            House house = optionalHouse.get();
            house.setAdress(adress);
            house.setDescription(description);
            house.setPreferences(preferences);
            house.setEnabled(enabled);

            if (file != null && !file.isEmpty()) {
                try {
                    String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                    String uploadDir = "uploads/";
                    Path path = Paths.get(uploadDir + fileName);
                    Files.createDirectories(path.getParent());
                    Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                    house.setPhoto(fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            houseRepository.save(house);
            return true;
        }
        return false;
    }
}

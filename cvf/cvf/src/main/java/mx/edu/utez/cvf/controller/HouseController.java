package mx.edu.utez.cvf.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import mx.edu.utez.cvf.entity.House;
import mx.edu.utez.cvf.serviceImpl.HouseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/v1/houses")
@CrossOrigin(origins = "http://localhost:5173") // Asegura conexión con frontend
public class HouseController {

    @Autowired
    private HouseServiceImpl houseServiceImpl;

    //  Listar casas
    @GetMapping("/list")
    public List<House> getAllHouses() {
        return houseServiceImpl.listHouses();
    }

    //  Buscar por ID (formato Optional)
    @GetMapping("/findById/{id}")
    public ResponseEntity<House> getHouseById(@PathVariable Long id) {
        Optional<House> house = houseServiceImpl.findById(id);
        return house.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //  Guardar nueva casa con imagen (multipart)
    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveHouse(
            @RequestParam("adress") String adress,
            @RequestParam("description") String description,
            @RequestParam("preferences") String preferences,
            @RequestParam("enabled") boolean enabled,
            @RequestParam(value = "file", required = false) MultipartFile file
    ) {
        try {
            boolean saved = houseServiceImpl.saveHouse(adress, description, preferences, enabled, file);
            if (saved) {
                return ResponseEntity.ok("Residencia guardada exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la residencia");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    // ✅ Actualizar casa con imagen
    @PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateHouse(
            @PathVariable Long id,
            @RequestParam("adress") String adress,
            @RequestParam("description") String description,
            @RequestParam("preferences") String preferences,
            @RequestParam("enabled") boolean enabled,
            @RequestParam(value = "file", required = false) MultipartFile file
    ) {
        try {
            boolean updated = houseServiceImpl.updateHouse(id, adress, description, preferences, enabled, file);
            if (updated) {
                return ResponseEntity.ok("Residencia actualizada correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Residencia no encontrada");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar: " + e.getMessage());
        }
    }

    // ✅ Eliminar (lógica) residencia
    @DeleteMapping("/delete/{id}")
    public Boolean deleteHouse(@PathVariable Long id) {
        return houseServiceImpl.deleteHouse(id);
    }

    // ✅ Obtener imagen
    @GetMapping("/uploads/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) throws IOException {
        Path file = Paths.get("uploads", filename);
        Resource resource = new UrlResource(file.toUri());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }
}

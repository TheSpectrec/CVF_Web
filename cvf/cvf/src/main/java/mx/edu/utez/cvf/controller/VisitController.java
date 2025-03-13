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

import mx.edu.utez.cvf.entity.Visit;
import mx.edu.utez.cvf.serviceImpl.VisitServiceImpl;

@RestController
@RequestMapping(value = "/api/v1/visits")
public class VisitController {

    @Autowired
    private VisitServiceImpl serviceImpl;

    @GetMapping("/list")
    public List<Visit> getAllVisits() {
        return serviceImpl.listVisits();
    }

    @GetMapping("/findById/{visit_id}")
    public Visit findVisitById(@PathVariable Long visit_id) {
        return serviceImpl.findById(visit_id);
    }

    @PostMapping("/save")
    public Boolean saveVisit(@RequestBody Visit visit) {
        return serviceImpl.saveVisit(visit);
    }

    @PutMapping("/update")
    public Boolean updateVisit(@RequestBody Visit visit) {
        return serviceImpl.saveVisit(visit);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteVisit(@PathVariable Long id) {
        return serviceImpl.deleteVisit(id);
    }
}

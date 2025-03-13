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

import mx.edu.utez.cvf.entity.VisitType;
import mx.edu.utez.cvf.serviceImpl.VisitTypeServiceImpl;

@RestController
@RequestMapping(value = "/api/v1/visitTypes")
public class VisitTypeController {

    @Autowired
    private VisitTypeServiceImpl serviceImpl;

    @GetMapping("/list")
    public List<VisitType> getAllVisits() {
        return serviceImpl.listVisitTypes();
    }

    @GetMapping("/findById/{visit_type_id}")
    public VisitType findVisitById(@PathVariable Long visit_type_id) {
        return serviceImpl.findById(visit_type_id);
    }

    @PostMapping("/save")
    public Boolean saveVisit(@RequestBody VisitType visit) {
        return serviceImpl.saveVisitType(visit);
    }

    @PutMapping("/update")
    public Boolean updateVisit(@RequestBody VisitType visit) {
        return serviceImpl.saveVisitType(visit);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteVisit(@PathVariable Long visit_type_id) {
        return serviceImpl.deleteVisitType(visit_type_id);
    }
}

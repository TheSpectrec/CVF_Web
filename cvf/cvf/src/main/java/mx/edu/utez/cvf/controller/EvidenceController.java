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

import mx.edu.utez.cvf.entity.Evidence;
import mx.edu.utez.cvf.serviceImpl.EvidenceServiceImpl;

@RestController
@RequestMapping(value = "/api/v1/evidences")
public class EvidenceController {

    @Autowired
    private EvidenceServiceImpl serviceImpl;

    @GetMapping("/list")
    public List<Evidence> getAllEvidences() {
        return serviceImpl.listEvidences();
    }

    @GetMapping("/findById/{evidence_id}")
    public Evidence findEvidenceById(@PathVariable Long evidence_id) {
        return serviceImpl.findById(evidence_id);
    }

    @PostMapping("/save")
    public Boolean saveEvidence(@RequestBody Evidence evidence) {
        return serviceImpl.saveEvidence(evidence);
    }

    @PutMapping("/update")
    public Boolean updateEvidence(@RequestBody Evidence evidence) {
        return serviceImpl.saveEvidence(evidence);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteEvidence(@PathVariable Long id) {
        return serviceImpl.deleteEvidence(id);
    }
}

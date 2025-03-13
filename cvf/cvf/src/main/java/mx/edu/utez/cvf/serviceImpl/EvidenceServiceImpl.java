package mx.edu.utez.cvf.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.cvf.entity.Evidence;
import mx.edu.utez.cvf.repository.EvidenceRepository;
import mx.edu.utez.cvf.service.EvidenceService;

@Service
public class EvidenceServiceImpl implements EvidenceService {

    @Autowired
    private EvidenceRepository evidenceRepository;

    @Override
    public List<Evidence> listEvidences() {
        return evidenceRepository.findAll();
    }

    @Override
    public Evidence findById(Long id) {
        Optional<Evidence> evidence = evidenceRepository.findById(id);
        if (evidence.isPresent()) {
            return evidence.get();
        }
        return null;
    }

    @Override
    public Boolean saveEvidence(Evidence evidence) {
        boolean response = false;
        Evidence evidenceSaved = evidenceRepository.save(evidence);
        if (evidenceSaved != null) {
            response = true;
        }
        return response;
    }

    @Override
    public Boolean updateEvidence(Evidence evidence) {
        boolean response = false;
        Evidence evidenceUpdate = evidenceRepository.save(evidence);
        if (evidenceUpdate != null) {
            response = true;
        }
        return response;
    }

    @Override
    public Boolean deleteEvidence(Long id) {
        Boolean response = false;
        if (evidenceRepository.findById(id).isPresent()) {
            evidenceRepository.deleteById(id);
            response = true;
        }
        return response;
    }

}

package mx.edu.utez.cvf.service;

import java.util.List;

import mx.edu.utez.cvf.entity.Evidence;

public interface EvidenceService {

    List<Evidence> listEvidences();

    Evidence findById(Long id);

    Boolean saveEvidence(Evidence evidence);

    Boolean updateEvidence(Evidence evidence);

    Boolean deleteEvidence(Long id);
}

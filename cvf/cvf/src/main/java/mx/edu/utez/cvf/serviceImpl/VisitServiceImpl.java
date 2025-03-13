package mx.edu.utez.cvf.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.cvf.entity.Visit;
import mx.edu.utez.cvf.repository.VisitRepository;
import mx.edu.utez.cvf.service.VisitService;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Override
    public List<Visit> listVisits() {
        return visitRepository.findAll();
    }

    @Override
    public Visit findById(Long id) {
        Optional<Visit> visit = visitRepository.findById(id);
        if (visit.isPresent()) {
            return visit.get();
        }
        return null;
    }

    @Override
    public Boolean saveVisit(Visit visit) {
        boolean response = false;
        Visit visitSaved = visitRepository.save(visit);
        if (visitSaved != null) {
            response = true;
        }
        return response;
    }

    @Override
    public Boolean updateVisit(Visit visit) {
        boolean response = false;
        Visit visitSaved = visitRepository.save(visit);
        if (visitSaved != null) {
            response = true;
        }
        return response;
    }

    @Override
    public Boolean deleteVisit(Long id) {
        Boolean response = false;
        if (visitRepository.findById(id).isPresent()) {
            visitRepository.deleteById(id);
            response = true;
        }
        return response;
    }

}

package mx.edu.utez.cvf.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.cvf.entity.VisitType;
import mx.edu.utez.cvf.repository.VisitTypeRepository;
import mx.edu.utez.cvf.service.VisitTypeService;

@Service
public class VisitTypeServiceImpl implements VisitTypeService {

    @Autowired
    private VisitTypeRepository visitTypeRepository;

    @Override
    public List<VisitType> listVisitTypes() {
        return visitTypeRepository.findAll();
    }

    @Override
    public VisitType findById(Long id) {
        Optional<VisitType> visitType = visitTypeRepository.findById(id);
        if (visitType.isPresent()) {
            return visitType.get();
        }
        return null;
    }

    @Override
    public Boolean saveVisitType(VisitType visitType) {
        boolean response = false;
        VisitType visitTypeSaved = visitTypeRepository.save(visitType);
        if (visitTypeSaved != null) {
            response = true;
        }
        return response;
    }

    @Override
    public Boolean updateVisitType(VisitType visitType) {
        boolean response = false;
        VisitType visitTypeSaved = visitTypeRepository.save(visitType);
        if (visitTypeSaved != null) {
            response = true;
        }
        return response;
    }

    @Override
    public Boolean deleteVisitType(Long id) {
        Boolean response = false;
        if (visitTypeRepository.findById(id).isPresent()) {
            visitTypeRepository.deleteById(id);
            response = true;
        }
        return response;
    }

}

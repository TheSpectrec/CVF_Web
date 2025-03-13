package mx.edu.utez.cvf.service;

import java.util.List;

import mx.edu.utez.cvf.entity.VisitType;

public interface VisitTypeService {

    List<VisitType> listVisitTypes();

    VisitType findById(Long id);

    Boolean saveVisitType(VisitType visitType);

    Boolean updateVisitType(VisitType visitType);

    Boolean deleteVisitType(Long id);
}

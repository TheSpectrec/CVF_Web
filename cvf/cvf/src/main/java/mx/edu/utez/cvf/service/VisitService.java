package mx.edu.utez.cvf.service;

import java.util.List;

import mx.edu.utez.cvf.entity.Visit;

public interface VisitService {

    List<Visit> listVisits();

    Visit findById(Long id);

    Boolean saveVisit(Visit visit);

    Boolean updateVisit(Visit visit);

    Boolean deleteVisit(Long id);
}

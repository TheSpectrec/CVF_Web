package mx.edu.utez.cvf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.cvf.entity.VisitType;

@Repository
public interface VisitTypeRepository extends JpaRepository<VisitType, Long> {

}

package mx.edu.utez.cvf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.cvf.entity.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

}

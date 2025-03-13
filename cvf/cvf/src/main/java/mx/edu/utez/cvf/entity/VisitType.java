package mx.edu.utez.cvf.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "visit_types")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitType {

    @Id
    @Column(name = "visit_type_id")
    private Long visit_type_id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "visit_type_id")
    private Set<Visit> visit_id;
}

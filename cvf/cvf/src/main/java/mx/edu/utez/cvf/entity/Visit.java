package mx.edu.utez.cvf.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "visits")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_id")
    private Long visit_id;

    @Column(name = "date")
    private Date date;

    @Column(name = "person_num")
    private int person_num;

    @Column(name = "description")
    private String description;

    @Column(name = "password")
    private String password;

    @Column(name = "person_name")
    private String person_name;

    @Column(name = "observation")
    private String observation;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house_id;

    @ManyToOne
    @JoinColumn(name = "visit_type_id")
    private VisitType visit_type_id;

    @OneToMany(mappedBy = "visit_id")
    private Set<Evidence> evidence_id;
}

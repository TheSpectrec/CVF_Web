package mx.edu.utez.cvf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "evidences")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Evidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evidence_id")
    private Long evidence_id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "visit_id")
    private Visit visit_id;
}

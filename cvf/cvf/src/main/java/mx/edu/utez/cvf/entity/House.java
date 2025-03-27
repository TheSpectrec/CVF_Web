package mx.edu.utez.cvf.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "houses")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id")
    private Long house_id;

    @Column(name = "description")
    private String description;

    @Column(name = "photo")
    private String photo;

    @Column(name = "adress")
    private String adress;

    @Column(name = "preferences")
    private String preferences;

    @Column(name = "enabled")
    private boolean enabled; // ✅ Agregado campo booleano para eliminación lógica

    @OneToOne(mappedBy = "house_id")
    private User user;

    @OneToMany(mappedBy = "house_id")
    private Set<Visit> Visit_id;
}

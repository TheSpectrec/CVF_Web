package mx.edu.utez.cvf.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    @Id
    @Column(name = "name", length = 50)
    private String name;

    @ManyToMany(mappedBy = "rols")
    private Set<User> users;
}

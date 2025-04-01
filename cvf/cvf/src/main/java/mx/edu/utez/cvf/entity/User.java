package mx.edu.utez.cvf.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "paternal", nullable = false)
    private String paternal;

    @Column(name = "maternal", nullable = true)
    private String maternal;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "birthday", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "house_id", referencedColumnName = "house_id")
    private House house;

    @ManyToMany
    @JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "authority"))
    private Set<Rol> rols = new HashSet<>();
}

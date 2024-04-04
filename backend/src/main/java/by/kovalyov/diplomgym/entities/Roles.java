package by.kovalyov.diplomgym.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "user_roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    @NotNull
    private String roleName;

    @OneToMany(fetch = FetchType.EAGER)
    private List<User> user;
}

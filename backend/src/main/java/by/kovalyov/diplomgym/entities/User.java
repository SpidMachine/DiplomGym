package by.kovalyov.diplomgym.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    @NotNull
    @Size(min = 3, max = 20)
//    @Pattern(regexp = "/^[a-zA-Z](.[a-zA-Z0-9_-]*)$/")
    private String login;

    @Column(name = "password")
    @NotNull
    @Size(min = 3, max = 20)
    private String password;

    @Column(name = "name")
    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @Column(name = "email")
    @NotNull
    @Size(min = 3, max = 50)
//    @Pattern(regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")
    private String email;

    @NotNull
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Roles role;
}

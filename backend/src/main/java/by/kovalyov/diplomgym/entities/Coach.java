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
@Table(name = "coach")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    @NotNull
    @Size(min = 3, max = 20)
    private String login;

    @Column(name = "password")
    @NotNull
    @Size(min = 3, max = 20)
    private String password;

    @Column(name = "name")
    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @Column(name = "experience")
    @NotNull
    private int experience;
}

package by.kovalyov.diplomgym.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotNull
    @Size(min = 3, max = 20)
    private String firstName;

    @Column(name = "second_name")
    @NotNull
    @Size(min = 3, max = 20)
    private String secondName;

    @Column(name = "email")
    @NotNull
//    @Pattern(regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")
    private String email;

    @Column(name = "password")
    @NotNull
    @Size(min = 3, max = 20)
    private String password;

    @Column(name = "birthday")
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

    @Column(name = "gender")
    @NotNull
    private String gender;

    @Column(name = "phone_number")
    @NotNull
    private String phoneNumber;
}

package by.kovalyov.diplomgym.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "email")
    @NotBlank
    private String email;

    @Column(name = "phone_number")
    @NotBlank
    private String phoneNumber;

    @Column(name = "specialization")
    @NotBlank
    private String specialization;

    @Column(name = "description")
    @NotBlank
    private String description;

    @Column(name = "place")
    @NotBlank
    private String place;

    @Column(name = "photo_url")
    private String photoUrl;
}

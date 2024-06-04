package by.kovalyov.diplomgym.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "reg_for_workouts")
public class RegForWorkouts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private UserGym userGymId;

    @JoinColumn(name = "workout_id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Workout workoutId;

    @Column(name = "registration_time")
    @NotNull
    private LocalDateTime regTime;

    @Column(name = "status")
    @NotNull
    private String status;
}

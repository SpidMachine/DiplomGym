package by.kovalyov.diplomgym.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_training")
    @NotNull
    private String nameOfTraining;

    @Column(name = "start_training")
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTraining;

    @Column(name = "end_training")
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTraining;

    @Column(name = "day_of_week")
    @NotNull
    private String dayWeek;

    @Column(name = "max_people")
    @NotNull
    private int maxPeople;

    @Column(name = "current_people")
    @NotNull
    private int currentPeople;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_id")
    @NotNull
    private Coach coachId;
}

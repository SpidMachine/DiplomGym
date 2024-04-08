package by.kovalyov.diplomgym.repo;

import by.kovalyov.diplomgym.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    @Query(value = "SELECT * FROM workouts WHERE coach_name = ?1", nativeQuery = true)
    List<Workout> getWorkoutsByCoachName(String coachName);
}

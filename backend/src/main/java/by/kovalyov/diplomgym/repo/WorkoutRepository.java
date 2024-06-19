package by.kovalyov.diplomgym.repo;

import by.kovalyov.diplomgym.entities.UserGym;
import by.kovalyov.diplomgym.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    @Query(value = "SELECT * FROM workouts WHERE coach_id = ?1", nativeQuery = true)
    List<Workout> getWorkoutsByCoachId(Long coachId);
    @Query(value = "SELECT * FROM workouts WHERE user_id = ?1", nativeQuery = true)
    List<Workout> getWorkoutsByUserGymId(Long userId);
}

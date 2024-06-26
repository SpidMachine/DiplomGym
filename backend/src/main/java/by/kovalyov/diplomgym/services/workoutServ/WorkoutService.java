package by.kovalyov.diplomgym.services.workoutServ;

import by.kovalyov.diplomgym.dto.WorkoutDto;
import by.kovalyov.diplomgym.entities.Workout;

import java.util.List;

public interface WorkoutService {
    Workout getWorkoutById(Long id);
    List<Workout> getWorkouts();
    Workout createWorkout(Workout workout);
    Workout updateWorkout(Long id, Workout workout);
    Workout deleteWorkout(Long id);
    List<Workout> getWorkoutsByCoachId(Long coachId);
    List<Workout> getWorkoutsByUserGymId(Long id);
}

package by.kovalyov.diplomgym.services.workoutServ;

import by.kovalyov.diplomgym.entities.Coach;
import by.kovalyov.diplomgym.entities.UserGym;
import by.kovalyov.diplomgym.entities.Workout;
import by.kovalyov.diplomgym.repo.UserRepository;
import by.kovalyov.diplomgym.repo.WorkoutRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService {
    private final WorkoutRepository workoutRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public Workout getWorkoutById(Long id) {
        return workoutRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found workout"));
    }

    @Override
    public List<Workout> getWorkouts() {
        return workoutRepository.findAll();
    }

    @Override
    @Transactional
    public Workout createWorkout(Workout workout) {
        return entityManager.merge(workout);
    }

    @Override
    public Workout updateWorkout(Long id, Workout workout) {
        Workout _workout = workoutRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        _workout.setDescription(workout.getDescription());
        _workout.setUserGymId(workout.getUserGymId());
        _workout.setCoachId(workout.getCoachId());
        _workout.setStatus(workout.getStatus());

        return workoutRepository.save(_workout);
    }

    @Override
    public Workout deleteWorkout(Long id) {
        Workout workout = workoutRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        workoutRepository.deleteById(id);
        return workout;
    }

    @Override
    public List<Workout> getWorkoutsByCoachId(Long coachId) {
        return workoutRepository.getWorkoutsByCoachId(coachId);
    }

    @Override
    public List<Workout> getWorkoutsByUserGymId(Long id) {
        return workoutRepository.getWorkoutsByUserGymId(id);
    }
}

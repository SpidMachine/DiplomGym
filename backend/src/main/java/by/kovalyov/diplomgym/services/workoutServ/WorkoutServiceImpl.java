package by.kovalyov.diplomgym.services.workoutServ;

import by.kovalyov.diplomgym.entities.Workout;
import by.kovalyov.diplomgym.repo.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService {
    final WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public Workout getWorkoutById(Long id) {
        return workoutRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Workout> getWorkouts() {
        return workoutRepository.findAll();
    }

    @Override
    public Workout createWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    @Override
    public Workout updateWorkout(Long id, Workout workout) {
        Workout _workout = workoutRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        _workout.setNameOfGymPost(workout.getNameOfGymPost());
        _workout.setStartTraining(workout.getStartTraining());
        _workout.setEndTraining(workout.getEndTraining());
        _workout.setDayWeek(workout.getDayWeek());
        _workout.setMaxPeople(workout.getMaxPeople());
        _workout.setCurrentPeople(workout.getCurrentPeople());
        _workout.setCoachId(workout.getCoachId());

        return workoutRepository.save(_workout);
    }

    @Override
    public Workout deleteWorkout(Long id) {
        Workout workout = workoutRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        workoutRepository.deleteById(id);
        return workout;
    }

    @Override
    public List<Workout> getWorkoutsByCoachName(String coachName) {
        return workoutRepository.getWorkoutsByCoachName(coachName);
    }
}

package by.kovalyov.diplomgym.controllers;

import by.kovalyov.diplomgym.entities.Workout;
import by.kovalyov.diplomgym.services.workoutServ.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutController {
    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping("/workouts/{coachName}")
    public List<Workout> getWorkoutsByCoachName(@PathVariable String coachName) {
        return workoutService.getWorkoutsByCoachName(coachName);
    }

    @GetMapping("/workouts")
    public List<Workout> getWorkouts() {
        return workoutService.getWorkouts();
    }

    @PostMapping("/workouts")
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout) {
        Workout _workout = workoutService.createWorkout(workout);
        return new ResponseEntity<>(_workout, HttpStatus.CREATED);
    }

    @PutMapping("/workouts/{id}")
    public ResponseEntity<Workout> updateWorkout(@PathVariable Long id, @RequestBody Workout workout) {
        Workout _workout = workoutService.updateWorkout(id, workout);
        return new ResponseEntity<>(_workout, HttpStatus.OK);
    }

    @DeleteMapping("/workouts/{id}")
    public ResponseEntity<Workout> deleteWorkout(@PathVariable Long id) {
        Workout deletedWorkout = workoutService.deleteWorkout(id);
        return new ResponseEntity<>(deletedWorkout, HttpStatus.OK);
    }
}

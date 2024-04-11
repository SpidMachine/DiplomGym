import { Component } from '@angular/core';
import {Workout} from "../entities/workout";
import {FormsModule} from "@angular/forms";
import {WorkoutService} from "../services/workout.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-workout',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './create-workout.component.html',
  styleUrl: './create-workout.component.css'
})
export class CreateWorkoutComponent {
  workout: Workout = new Workout();

  constructor(private workoutService: WorkoutService, private router: Router) {
  }

  ngOnInit() {
  }

  saveWorkout() {
    this.workoutService.createWorkout(this.workout).subscribe({
      next: (v) => console.log(v),
      error: console.error,
      complete: () => this.goToWorkoutList()
    });
  }

  goToWorkoutList() {
    this.router.navigate(['/workouts']);
  }

  onSubmit() {
    console.log(this.workout);
    this.saveWorkout();
  }
}

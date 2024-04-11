import { Component, OnInit } from '@angular/core';
import {NgForOf, NgIf} from "@angular/common";
import {Workout} from "../entities/workout";
import {WorkoutService} from "../services/workout.service";
import {HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-workout-list',
  standalone: true,
  imports: [
    NgIf,
    HttpClientModule,
    NgForOf
  ],
  templateUrl: './workout-list.component.html',
  styleUrl: './workout-list.component.css'
})
export class WorkoutListComponent implements OnInit {
  workouts: Workout[] | undefined;

  constructor(private workoutService: WorkoutService) {
  }

  ngOnInit(): void {
    this.getWorkouts();
  }

  getWorkouts(): void {
    this.workoutService.getAllWorkouts().subscribe(data=> {
      this.workouts = data;
    })
  }
}

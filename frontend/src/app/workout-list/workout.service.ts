import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Workout} from "../entities/workout";
import {User} from "../entities/user";

@Injectable({
  providedIn: 'root'
})
export class WorkoutService {
  private apiUrl = "http://localhost:8080/workouts";

  constructor(private http: HttpClient) { }

  getAllWorkouts(): Observable<Workout[]> {
    return this.http.get<Workout[]>(this.apiUrl);
  }

  createWorkout(workout: Workout): Observable<Object> {
    console.log(this.apiUrl);
    return this.http.post(this.apiUrl, workout)
  }
}

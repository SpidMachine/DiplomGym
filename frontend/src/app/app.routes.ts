import {RouterModule, Routes} from '@angular/router';
import {NgModule} from "@angular/core";
import {UsersListComponent} from "./users-list/users-list.component";
import {CreateWorkoutComponent} from "./create-workout/create-workout.component";
import {WorkoutListComponent} from "./workout-list/workout-list.component";

export const routes: Routes = [
  {path: 'users', component: UsersListComponent},
  {path: 'workouts', component: WorkoutListComponent},
  {path: 'create-workout', component: CreateWorkoutComponent},
  {path: '', redirectTo: 'users', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {  }

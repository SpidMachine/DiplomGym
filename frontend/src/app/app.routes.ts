import {RouterModule, Routes} from '@angular/router';
import {NgModule} from "@angular/core";
import {UsersListComponent} from "./users-list/users-list.component";
import {CreatePostComponent} from "./create-post/create-post.component";

export const routes: Routes = [
  {path: 'users', component: UsersListComponent},
  {path: 'create-post', component: CreatePostComponent},
  {path: '', redirectTo: 'users', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {  }

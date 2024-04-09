import { Component } from '@angular/core';
import {Post} from "../entities/workout";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-create-post',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './create-post.component.html',
  styleUrl: './create-post.component.css'
})
export class CreatePostComponent {
  post: Post = new Post();

  constructor() {
  }

  onSubmit() {

  }

}

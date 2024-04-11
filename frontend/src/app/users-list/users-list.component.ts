import {Component, OnInit} from '@angular/core';
import {User} from "../entities/user";
import {UserService} from "../services/user.service";
import {NgForOf, NgIf} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-users-list',
  standalone: true,
  imports: [
    NgIf,
    HttpClientModule,
    NgForOf
  ],
  templateUrl: './users-list.component.html',
  styleUrl: './users-list.component.css'
})
export class UsersListComponent implements OnInit {
  users: User[] | undefined;

  constructor(private userService: UserService) {  }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(): void {
    this.userService.getAllUsers().subscribe(data=> {
      this.users = data;
    })
  }
}

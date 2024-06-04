import {Component, OnInit} from '@angular/core';
import {User} from "../entities/user";
import {UserService} from "./user.service";
import {NgForOf, NgIf} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {SharedModule} from "primeng/api";
import {TableModule} from "primeng/table";

@Component({
  selector: 'app-users-list',
  standalone: true,
    imports: [
        NgIf,
        HttpClientModule,
        NgForOf,
        SharedModule,
        TableModule
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

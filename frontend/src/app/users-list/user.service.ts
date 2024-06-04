import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { User } from "../entities/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {
private apiUrl = "http://localhost:8080/users";
  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.apiUrl);
  }

  getUserById(): Observable<User> {
    return this.http.get<User>("http://localhost:8080/users/{id}")
  }
}

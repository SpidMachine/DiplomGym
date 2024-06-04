package by.kovalyov.diplomgym.services.userServ;

import by.kovalyov.diplomgym.entities.UserGym;

import java.util.List;

public interface UserService {
    UserGym findUserById(Long id);
    List<UserGym> findAllUsers();
    UserGym createUser(UserGym userGym);
    UserGym updateUser(Long id, UserGym userGym);
    UserGym deleteUser(Long id);
}

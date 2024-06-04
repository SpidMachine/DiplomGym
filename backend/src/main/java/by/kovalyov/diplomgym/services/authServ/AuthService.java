package by.kovalyov.diplomgym.services.authServ;


import by.kovalyov.diplomgym.dto.SignupRequest;

public interface AuthService {
    boolean createUser(SignupRequest signupRequest);
}

package by.kovalyov.diplomgym.services.coachServ;

import by.kovalyov.diplomgym.entities.Coach;

import java.util.List;

public interface CoachService {
    List<Coach> findAllCoaches();
    Coach addNewCoach(Coach coach);
}

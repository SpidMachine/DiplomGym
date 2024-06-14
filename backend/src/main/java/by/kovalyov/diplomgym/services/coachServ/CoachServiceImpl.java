package by.kovalyov.diplomgym.services.coachServ;

import by.kovalyov.diplomgym.entities.Coach;
import by.kovalyov.diplomgym.repo.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepository;

    @Autowired
    public CoachServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public List<Coach> findAllCoaches() {
        return coachRepository.findAll();
    }

    @Override
    public Coach addNewCoach(Coach coach) {
        return coachRepository.save(coach);
    }
}

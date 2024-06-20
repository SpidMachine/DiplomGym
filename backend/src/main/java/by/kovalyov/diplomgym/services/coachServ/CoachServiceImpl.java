package by.kovalyov.diplomgym.services.coachServ;

import by.kovalyov.diplomgym.entities.Coach;
import by.kovalyov.diplomgym.repo.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public Coach findCoachById(Long id) {
        return coachRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public Coach addNewCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    @Override
    public Coach updateCoach(Coach coach, Long id) {
        Coach _coach = coachRepository.findById(id).orElseThrow();

        _coach.setName(coach.getName());
        _coach.setDescription(coach.getDescription());
        _coach.setEmail(coach.getEmail());
        _coach.setPlace(coach.getPlace());
        _coach.setPhoneNumber(coach.getPhoneNumber());
        _coach.setSpecialization(coach.getSpecialization());
        _coach.setPhotoUrl(coach.getPhotoUrl());
        coachRepository.save(_coach);

        return _coach;
    }

    @Override
    public Coach deleteCoach(Long id) {
        Coach coach = coachRepository.findById(id).orElseThrow();
        coachRepository.deleteById(id);
        return coach;
    }

    @Override
    public void addPhotoCoach(Coach coach, MultipartFile file) {
        Coach _coach = coachRepository.findById(coach.getId()).orElseThrow();

        _coach.setPhotoUrl(file.getOriginalFilename());
    }
}

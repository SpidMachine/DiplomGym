package by.kovalyov.diplomgym.services.coachServ;

import by.kovalyov.diplomgym.entities.Coach;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CoachService {
    List<Coach> findAllCoaches();
    Coach findCoachById(Long id);
    Coach addNewCoach(Coach coach);
    Coach updateCoach(Coach coach, Long id);
    Coach deleteCoach(Long id);
    void addPhotoCoach(Coach coach, MultipartFile file);
}

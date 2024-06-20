package by.kovalyov.diplomgym.services.coachServ;

import by.kovalyov.diplomgym.dto.controller.coach.CreateCoachRequestDto;
import by.kovalyov.diplomgym.entities.Coach;
import by.kovalyov.diplomgym.repo.CoachRepository;
import by.kovalyov.diplomgym.services.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepository;
    private final FileService fileService;

    @Override
    public List<Coach> findAllCoaches() {
        return coachRepository.findAll();
    }

    @Override
    public Coach findCoachById(Long id) {
        return coachRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public Coach addNewCoach(CreateCoachRequestDto coachRequestDto) {
        String path = fileService.saveFile(coachRequestDto.getPhotoBase64());

        Coach coach = new Coach();
        coach.setName(coachRequestDto.getName());
        coach.setEmail(coachRequestDto.getEmail());
        coach.setPlace(coachRequestDto.getPlace());
        coach.setSpecialization(coachRequestDto.getSpecialization());
        coach.setPhoneNumber(coachRequestDto.getPhoneNumber());
        coach.setDescription(coachRequestDto.getDescription());
        coach.setPhotoUrl(path);

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
}

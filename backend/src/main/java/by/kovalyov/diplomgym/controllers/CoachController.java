package by.kovalyov.diplomgym.controllers;

import by.kovalyov.diplomgym.dto.controller.coach.CreateCoachRequestDto;
import by.kovalyov.diplomgym.entities.Coach;
import by.kovalyov.diplomgym.services.coachServ.CoachServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CoachController {
    @Value("${upload.path}")
    private String uploadPath;
    private final CoachServiceImpl coachService;

    public CoachController(CoachServiceImpl coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/coaches")
    public List<Coach> getAllUsers() {
        return coachService.findAllCoaches();
    }

    @GetMapping("/coaches/{id}")
    public ResponseEntity<Coach> getUserById(@PathVariable Long id) {
        Coach coach = coachService.findCoachById(id);
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }

    @PostMapping(path = "/coaches/add")
    public ResponseEntity<Coach> addNewCoach(@RequestBody CreateCoachRequestDto coachRequestDto) throws IOException {
        Coach _coach = coachService.addNewCoach(coachRequestDto);

        return new ResponseEntity<>(_coach, HttpStatus.CREATED);
    }

    @PutMapping("/coaches/{id}")
    public ResponseEntity<Coach> updateCoach(@RequestBody Coach coach, @PathVariable Long id) {
        Coach _coach = coachService.updateCoach(coach, id);
        return new ResponseEntity<>(_coach, HttpStatus.CREATED);
    }

    @DeleteMapping("/coaches/{id}")
    public ResponseEntity<Coach> deleteCoach(@PathVariable Long id) {
        Coach coach = coachService.deleteCoach(id);
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }

    @PostMapping("/img")
    public String handleFileUpload(@RequestParam("name") String name, @RequestPart("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
            stream.write(bytes);
            stream.close();
            return "Вы удачно загрузили " + name + " в " + name + "-uploaded !";
        }
        return null;
    }
}

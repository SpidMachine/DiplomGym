package by.kovalyov.diplomgym.controllers;

import by.kovalyov.diplomgym.dto.CoachDto;
import by.kovalyov.diplomgym.entities.Coach;
import by.kovalyov.diplomgym.entities.UserGym;
import by.kovalyov.diplomgym.services.coachServ.CoachService;
import by.kovalyov.diplomgym.services.coachServ.CoachServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

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
    public ResponseEntity<Coach> addNewCoach(@RequestBody Coach coach, @RequestPart(value = "photoUrl", required = false) MultipartFile file) throws IOException {
        Coach _coach = coachService.addNewCoach(coach);

        if (file != null) {
            file.transferTo(new File(uploadPath + "/" + file.getOriginalFilename()));

            _coach.setPhotoUrl(file.getOriginalFilename());
        }

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

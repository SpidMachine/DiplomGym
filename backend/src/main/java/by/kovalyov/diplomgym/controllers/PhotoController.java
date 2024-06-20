package by.kovalyov.diplomgym.controllers;

import by.kovalyov.diplomgym.entities.Coach;
import by.kovalyov.diplomgym.services.coachServ.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PhotoController {

    private final CoachService coachService;

    @GetMapping("/photo/{id}")
    public ResponseEntity<byte[]> getCoachPhoto(@PathVariable Long id) {
        try {
            Coach coach = coachService.findCoachById(id);
            byte[] image = Files.readAllBytes(Paths.get(coach.getPhotoUrl()));
            return ResponseEntity.ok().body(image);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

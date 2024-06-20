package by.kovalyov.diplomgym.controllers;

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
public class PhotoController {

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/photo/{filename}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable String filename) {
        try {
            byte[] image = Files.readAllBytes(Paths.get(uploadPath, filename));
            return ResponseEntity.ok().body(image);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

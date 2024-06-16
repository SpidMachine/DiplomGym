package by.kovalyov.diplomgym.controllers;

import by.kovalyov.diplomgym.dto.CoachDto;
import by.kovalyov.diplomgym.entities.Coach;
import by.kovalyov.diplomgym.entities.UserGym;
import by.kovalyov.diplomgym.services.coachServ.CoachServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoachController {
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

    @PostMapping("/coaches/add")
    public ResponseEntity<Coach> addNewCoach(@RequestBody Coach coach) {
        Coach _coach = coachService.addNewCoach(coach);
        return new ResponseEntity<>(_coach, HttpStatus.CREATED);
    }


}

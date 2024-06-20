package by.kovalyov.diplomgym.controllers;

import by.kovalyov.diplomgym.dto.PhoneConsultationDto;
import by.kovalyov.diplomgym.entities.PhoneConsultation;
import by.kovalyov.diplomgym.services.phoneConsServ.PhoneConsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("phoneCons")
public class PhoneConsultationController {

    private final PhoneConsServiceImpl phoneConsService;

    public PhoneConsultationController(PhoneConsServiceImpl phoneConsService) {
        this.phoneConsService = phoneConsService;
    }

    @PostMapping("/sign-up")
    private ResponseEntity<PhoneConsultation> createPhoneConsultation(@RequestBody PhoneConsultation phoneConsultation) {
        PhoneConsultation _phoneConsultation = phoneConsService.addPhoneConsultation(phoneConsultation);
        return new ResponseEntity<>(_phoneConsultation, HttpStatus.CREATED);
    }

    @GetMapping
    private List<PhoneConsultation> getAllPhoneConsultation() {
        return phoneConsService.findAllPhoneConsultation();
    }

    @GetMapping("/{id}")
    private PhoneConsultation getPhoneConsultationById(@PathVariable Long id) {
        return phoneConsService.findPhoneConsultationById(id);
    }

    @PutMapping("/{id}")
    private ResponseEntity<PhoneConsultation> updatePhoneConsultation(@RequestBody PhoneConsultation phoneConsultation, @PathVariable Long id) {
        PhoneConsultation _phoneConsultation = phoneConsService.updatePhoneConsultation(phoneConsultation, id);
        return new ResponseEntity<>(_phoneConsultation, HttpStatus.CREATED);
    }
}

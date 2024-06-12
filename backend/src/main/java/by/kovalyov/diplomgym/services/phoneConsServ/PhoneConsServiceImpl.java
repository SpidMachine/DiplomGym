package by.kovalyov.diplomgym.services.phoneConsServ;

import by.kovalyov.diplomgym.entities.PhoneConsultation;
import by.kovalyov.diplomgym.repo.PhoneConsultationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneConsServiceImpl implements PhoneConsService {
    private final PhoneConsultationRepository phoneConsultationRepository;

    public PhoneConsServiceImpl(PhoneConsultationRepository phoneConsultationRepository) {
        this.phoneConsultationRepository = phoneConsultationRepository;
    }

    @Override
    public PhoneConsultation addPhoneConsultation(PhoneConsultation phoneConsultation) {
        return phoneConsultationRepository.save(phoneConsultation);
    }

    @Override
    public List<PhoneConsultation> findAllPhoneConsultation() {
        return phoneConsultationRepository.findAll();
    }
}

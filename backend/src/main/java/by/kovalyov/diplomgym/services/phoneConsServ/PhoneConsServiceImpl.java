package by.kovalyov.diplomgym.services.phoneConsServ;

import by.kovalyov.diplomgym.entities.PhoneConsultation;
import by.kovalyov.diplomgym.repo.PhoneConsultationRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public PhoneConsultation updatePhoneConsultation(PhoneConsultation phoneConsultation, Long id) {
        PhoneConsultation _phoneConsultation = phoneConsultationRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Phone consultation not found"));

        _phoneConsultation.setName(phoneConsultation.getName());
        _phoneConsultation.setPhoneNumber(phoneConsultation.getPhoneNumber());
        _phoneConsultation.setCoachName(phoneConsultation.getCoachName());
        _phoneConsultation.setStatus(phoneConsultation.getStatus());
        _phoneConsultation.setTimeRegistration(phoneConsultation.getTimeRegistration());
        phoneConsultationRepository.save(_phoneConsultation);

        return _phoneConsultation;
    }

    @Override
    public PhoneConsultation findPhoneConsultationById(Long id) {
        return phoneConsultationRepository.findById(id).orElseThrow();
    }
}

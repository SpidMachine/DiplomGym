package by.kovalyov.diplomgym.services.phoneConsServ;

import by.kovalyov.diplomgym.entities.PhoneConsultation;

import java.util.List;

public interface PhoneConsService {
    PhoneConsultation addPhoneConsultation(PhoneConsultation phoneConsultation);
    List<PhoneConsultation> findAllPhoneConsultation();
    PhoneConsultation updatePhoneConsultation(PhoneConsultation phoneConsultation, Long id);
    PhoneConsultation findPhoneConsultationById(Long id);
}

package by.kovalyov.diplomgym.repo;

import by.kovalyov.diplomgym.entities.PhoneConsultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneConsultationRepository extends JpaRepository<PhoneConsultation, Long> {
}

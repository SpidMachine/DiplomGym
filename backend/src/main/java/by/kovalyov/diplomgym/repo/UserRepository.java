package by.kovalyov.diplomgym.repo;

import by.kovalyov.diplomgym.entities.UserGym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserGym, Long> {
    boolean existsByPhoneNumber(String phoneNumber);

    Optional<UserGym> findByPhoneNumber(String phoneNumber);
}

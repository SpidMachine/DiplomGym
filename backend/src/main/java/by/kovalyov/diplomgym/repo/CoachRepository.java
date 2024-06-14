package by.kovalyov.diplomgym.repo;

import by.kovalyov.diplomgym.entities.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}

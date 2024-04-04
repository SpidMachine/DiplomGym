package by.kovalyov.diplomgym.repo;

import by.kovalyov.diplomgym.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

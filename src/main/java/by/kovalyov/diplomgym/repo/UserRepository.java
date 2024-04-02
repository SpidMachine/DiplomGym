package by.kovalyov.diplomgym.repo;

import by.kovalyov.diplomgym.entityes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
}

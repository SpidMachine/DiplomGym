package by.kovalyov.diplomgym.repo;

import by.kovalyov.diplomgym.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "SELECT * FROM posts WHERE coach_name = ?1", nativeQuery = true)
    List<Post> getPostsByCoachName(String coachName);
}

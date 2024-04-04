package by.kovalyov.diplomgym.services.postServ;

import by.kovalyov.diplomgym.entities.Post;
import by.kovalyov.diplomgym.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    Post getPostById(Long id);
    List<Post> getPosts();
    Post createPost(Post post);
    Post updatePost(Long id, Post post);
    Post deletePost(Long id);
    List<Post> getPostsByCoachName(String coachName);
}

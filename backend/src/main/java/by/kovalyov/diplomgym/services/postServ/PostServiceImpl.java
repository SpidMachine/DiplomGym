package by.kovalyov.diplomgym.services.postServ;

import by.kovalyov.diplomgym.entities.Post;
import by.kovalyov.diplomgym.repo.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post post) {
        Post _post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        _post.setCoachId(post.getCoachId());
        _post.setPostTime(post.getPostTime());
        _post.setUserId(post.getUserId());

        return postRepository.save(_post);
    }

    @Override
    public Post deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        postRepository.deleteById(id);
        return post;
    }

    @Override
    public List<Post> getPostsByCoachName(String coachName) {
        return postRepository.getPostsByCoachName(coachName);
    }
}

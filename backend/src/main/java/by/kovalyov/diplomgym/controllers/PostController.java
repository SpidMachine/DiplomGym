package by.kovalyov.diplomgym.controllers;

import by.kovalyov.diplomgym.entities.Post;
import by.kovalyov.diplomgym.entities.User;
import by.kovalyov.diplomgym.repo.PostRepository;
import by.kovalyov.diplomgym.services.postServ.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts/{coachName}")
    public List<Post> getPostsByCoachName(@PathVariable String coachName) {
        return postService.getPostsByCoachName(coachName);
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post _post = postService.createPost(post);
        return new ResponseEntity<>(_post, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        Post _post = postService.updatePost(id, post);
        return new ResponseEntity<>(_post, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable Long id) {
        Post deletedPost = postService.deletePost(id);
        return new ResponseEntity<>(deletedPost, HttpStatus.OK);
    }
}

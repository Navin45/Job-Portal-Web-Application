package com.navin.joblisting_backend.controller;

import com.navin.joblisting_backend.dto.PostRequestDTO;
import com.navin.joblisting_backend.dto.PostResponseDTO;
import com.navin.joblisting_backend.service.PostService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/api/posts/all");
    }

    @GetMapping("/all")
    public List<PostResponseDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/search/{text}")
    public List<PostResponseDTO> searchPosts(@PathVariable String text) {
        return postService.searchPosts(text);
    }

    @PostMapping("/add")
    public PostResponseDTO addPost(@Valid @RequestBody PostRequestDTO postRequestDTO) {
        return postService.addPost(postRequestDTO);
    }
}

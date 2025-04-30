package com.navin.joblisting_backend.service;

import com.navin.joblisting_backend.dto.PostRequestDTO;
import com.navin.joblisting_backend.dto.PostResponseDTO;
import com.navin.joblisting_backend.model.Post;
import com.navin.joblisting_backend.repository.PostRepository;
import com.navin.joblisting_backend.repository.SearchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private SearchRepository searchRepository;

    @Override
    public PostResponseDTO addPost(PostRequestDTO postRequestDTO) {
        log.info("Adding new job post: {}", postRequestDTO.getProfile());
        Post post = new Post();
        post.setProfile(postRequestDTO.getProfile());
        post.setDesc(postRequestDTO.getDesc());
        post.setExp(postRequestDTO.getExp());
        post.setTechs(List.of(postRequestDTO.getTechs()));

        Post savedPost = postRepository.save(post);
        log.info("Successfully added post with ID: {}", savedPost.getId());

        return mapToResponseDTO(savedPost);
    }

    @Override
    public List<PostResponseDTO> getAllPosts() {
        log.info("Fetching all job posts...");
        List<PostResponseDTO> posts = postRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
        log.info("Found {} posts", posts.size());
        return posts;
    }

    @Override
    public List<PostResponseDTO> searchPosts(String text) {
        log.info("Searching posts with text: {}", text);
        List<PostResponseDTO> posts = searchRepository.findByText(text)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
        log.info("Found {} posts matching search: {}", posts.size(), text);
        return posts;
    }

    private PostResponseDTO mapToResponseDTO(Post post) {
        PostResponseDTO dto = new PostResponseDTO();
        dto.setId(post.getId());
        dto.setProfile(post.getProfile());
        dto.setDesc(post.getDesc());
        dto.setExp(post.getExp());
        dto.setTechs(post.getTechs());
        return dto;
    }
}

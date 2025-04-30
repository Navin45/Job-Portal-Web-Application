package com.navin.joblisting_backend.service;

import com.navin.joblisting_backend.dto.PostRequestDTO;
import com.navin.joblisting_backend.dto.PostResponseDTO;
import java.util.List;

public interface PostService {

    PostResponseDTO addPost(PostRequestDTO postRequestDTO);

    List<PostResponseDTO> getAllPosts();

    List<PostResponseDTO> searchPosts(String text);
}

package com.navin.joblisting_backend.repository;
import com.navin.joblisting_backend.model.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);

}
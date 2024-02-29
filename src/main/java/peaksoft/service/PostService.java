package peaksoft.service;

import peaksoft.entities.Post;

import java.util.List;

public interface PostService {
    // find all
    List<Post> findAllByUserId(Long id);

    Long savePost(Long id, Post post);

    List<Post> findAllPosts();

    Post findById(Long postId);
}

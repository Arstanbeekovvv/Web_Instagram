package peaksoft.repository;

import peaksoft.entities.Post;

import java.util.List;

public interface PostRepository {
    // Crud methods

    // save

    // find by id

    // find all
    List<Post> findAllByUserId(Long id);

    Long savePostWithImage(Long id, Post post);

    List<Post> findAll();

    Post findById(Long postId);
    // update

    // delete
}

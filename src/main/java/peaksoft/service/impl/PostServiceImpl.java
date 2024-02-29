package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Post;
import peaksoft.repository.PostRepository;
import peaksoft.service.PostService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;


    @Override
    public List<Post> findAllByUserId(Long id) {
        return postRepository.findAllByUserId(id);
    }

    @Override
    public Long savePost(Long id, Post post) {
        post.setCreatedAt(LocalDate.now());
        return postRepository.savePostWithImage(id, post);
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long postId) {
        return postRepository.findById(postId);
    }
}

package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Post;
import peaksoft.entities.User;
import peaksoft.repository.PostRepository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class PostRepoImpl implements PostRepository {
    private final EntityManager entityManager;

    @Override
    public List<Post> findAllByUserId(Long id) {
        return entityManager.createQuery("select p from Post p where p.user.id = :id", Post.class).setParameter("id", id).getResultList();
    }

    @Override
    public Long savePostWithImage(Long id, Post post) {
        User user = entityManager.find(User.class, id);
        post.setUser(user);
        entityManager.persist(post);
        user.getPosts().add(post);
        return post.getId();
    }

    @Override
    public List<Post> findAll() {
        return entityManager.createQuery("select p from Post p", Post.class).getResultList();
    }

    @Override
    public Post findById(Long postId) {
        return entityManager.find(Post.class, postId);
    }
}

package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.controller.RegistrationController;
import peaksoft.entities.Image;
import peaksoft.entities.Post;
import peaksoft.entities.User;
import peaksoft.repository.ImageRepository;

@Repository
@Transactional
@RequiredArgsConstructor
public class ImageRepoImpl implements ImageRepository {
    @PersistenceContext
    private final EntityManager entityManager;


    @Override
    public void saveImageWithPost(Image image) {
//        User user = entityManager.find(User.class, userId);
//        user
//
//        Post post = entityManager.find(Post.class, image.getPost().getId());
//        if(post != null){
//            post.getImages().add(image);
//            image.setPost(post);
//            entityManager.persist(image);
//        }
        entityManager.persist(image);
        User user = entityManager.find(User.class, RegistrationController.id);
        user.getPosts().add(image.getPost());
        image.getPost().setUser(user);
    }
}

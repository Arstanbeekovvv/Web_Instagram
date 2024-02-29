package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Image;
import peaksoft.entities.Post;
import peaksoft.repository.ImageRepository;
import peaksoft.service.ImageService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    @Override
    public void saveImage(Image image) {
        image.getPost().setCreatedAt(LocalDate.now());
        imageRepository.saveImageWithPost(image);
    }

    @Override
    public List<Image> findAllImageByPosts(List<Post> allByUserId) {
        List<Image> images = new ArrayList<>();
        for (Post post : allByUserId) {
            images.addAll(post.getImages());
        }

        return images;
    }
}

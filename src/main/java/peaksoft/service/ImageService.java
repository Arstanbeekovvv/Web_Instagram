package peaksoft.service;

import peaksoft.entities.Image;
import peaksoft.entities.Post;

import java.util.List;

public interface ImageService {
    void saveImage(Image image);

    List<Image> findAllImageByPosts(List<Post> allByUserId);
}

package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Comment;
import peaksoft.entities.Image;
import peaksoft.entities.Post;
import peaksoft.entities.User;
import peaksoft.service.ImageService;
import peaksoft.service.PostService;
import peaksoft.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/instagram.com/user")
public class PostController {
    private final PostService postService;
    private final ImageService imageService;
    private final UserService userService;

    @GetMapping("/new-post")
    public String createNewPost(Model model) {
        model.addAttribute("newImage", new Image());
        return "user/post/new-post";
    }

    @PostMapping("/savenewpost")
    public String saveNewPost(@ModelAttribute("newImage") Image image) {
        imageService.saveImage(image);
        return "redirect:/instagram.com/user";
    }

    @GetMapping("/open-post/{id}")
    public String openPost(@PathVariable("id") Long postId, Model model){
        Post post = postService.findById(postId);
        model.addAttribute("user", userService.findById(RegistrationController.id));
        model.addAttribute("findPost", post);
        model.addAttribute("newComment", new Comment());
        return "/user/post/post-page";
    }
}

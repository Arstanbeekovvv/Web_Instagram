package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.User;
import peaksoft.service.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/instagram.com/user/follower")
public class FollowerController {
    private final UserService userService;
    private final FollowerService followerService;
    private final UserInfoService userInfoService;
    private final PostService postService;
    private final ImageService imageService;

    @GetMapping
    public String myHandlerMethod(@RequestParam("userId") Long idUser, Model model) {
        if (idUser.equals(RegistrationController.id)) return "redirect:/instagram.com/user/profile";
        model.addAttribute("boolean", followerService.testFollower(RegistrationController.id, idUser));
        model.addAttribute("user", userService.findById(idUser));
        model.addAttribute("subscribers", followerService.getCountSubscribers(idUser));
        model.addAttribute("subscriptions", followerService.getCountSubscriptions(idUser));
        model.addAttribute("publications", postService.findAllByUserId(idUser) == null? 0: postService.findAllByUserId(idUser).size());
        model.addAttribute("publications", postService.findAllByUserId(idUser).size());
        model.addAttribute("posts", postService.findAllByUserId(idUser));
        model.addAttribute("images", imageService.findAllImageByPosts(postService.findAllByUserId(idUser)));
        model.addAttribute("subscribersUser", followerService.getAllSubscribersByUserId(idUser));
        model.addAttribute("subscriptionsUser", followerService.getAllSubscriptionsByUserId(idUser));
        return "user/follower/users-page"; // Название представления, которое нужно вернуть
    }

    @PostMapping("/action")
    @ResponseBody
    public String subscribe(@RequestParam Long userId, Model model) {
        followerService.actionFollower(RegistrationController.id, userId);
        return "success"; // Можно вернуть любой другой ответ
    }
}

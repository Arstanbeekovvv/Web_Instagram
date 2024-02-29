package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.service.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/instagram.com/user")
public class UserController {
    private final UserService userService;
    private final FollowerService followerService;
    private final UserInfoService userInfoService;
    private final PostService postService;
    private final ImageService imageService;

    @GetMapping
    public String oftenUserHome(Model model){
        model.addAttribute("user", userService.findById(RegistrationController.id));
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("posts", postService.findAllPosts());
        return "user/user-home";
    }

    @GetMapping("/profile")
    public String oftenUserProfile(Model model){
        model.addAttribute("user", userService.findById(RegistrationController.id));
        model.addAttribute("subscribers", followerService.getCountSubscribers(RegistrationController.id));
        model.addAttribute("subscriptions", followerService.getCountSubscriptions(RegistrationController.id));
        model.addAttribute("publications", postService.findAllByUserId(RegistrationController.id).size());
        model.addAttribute("posts", postService.findAllByUserId(RegistrationController.id));
        model.addAttribute("images", imageService.findAllImageByPosts(postService.findAllByUserId(RegistrationController.id)));
        model.addAttribute("subscribersUser", followerService.getAllSubscribersByUserId(RegistrationController.id));
        model.addAttribute("subscriptionsUser", followerService.getAllSubscriptionsByUserId(RegistrationController.id));
        return "user/user-profile";
    }

    @GetMapping("/edituserinfo")
    public String editProfile(Model model){
        model.addAttribute("newUserInfo", new UserInfo());
        model.addAttribute("user", userService.findById(RegistrationController.id));
        return "user/editProfile";
    }
    @PostMapping("/saveinfo")
    public String saveNewUserInfo(@ModelAttribute("newUserInfo") UserInfo userinfo){
        userInfoService.updateUserInfoByUserId(RegistrationController.id, userinfo);
        return "redirect:/instagram.com/user/profile";
    }

    @GetMapping("/search-query")
    public String resultSearch(Model model){
//        model.addAttribute("Recent", )
        String userName = "";
        model.addAttribute("userName", userName);
        return "user/search/search-users";
    }

    @GetMapping("/res-search-query")
    public String searchQuery(Model model, @RequestParam("userName") String userName){
//        model.addAttribute("Recent", )
        List<User> users = userService.searchUser(userName);
        model.addAttribute("resultSearch", users);
        return "user/search/search-users";
    }

    @GetMapping("/subscribers")
    public String getAllSubscribers(Model model){
        User user = userService.findById(RegistrationController.id);
        model.addAttribute("subscribers", user.getFollower().getSubscribers());
        return "user/follower/subscribers-page";
    }

}

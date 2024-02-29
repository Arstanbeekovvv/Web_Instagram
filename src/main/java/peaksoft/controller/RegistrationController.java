package peaksoft.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Follower;
import peaksoft.entities.User;
import peaksoft.service.FollowerService;
import peaksoft.service.ImageService;
import peaksoft.service.PostService;
import peaksoft.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/instagram.com/login")
public class RegistrationController {
    private final UserService userService;
    private final FollowerService followerService;
    private final PostService postService;
    private final ImageService imageService;
    public static Long id = null;

    @GetMapping
    public String signIn(Model model){
        model.addAttribute("newUserForSignIn", new User());
        return "sign-in";
    }

    @PostMapping("/log")
    public String logIn(@ModelAttribute("newUserForSignIn") User user, Model model){
        try {
            User user1 = userService.findByUserName(user);
            if(user1 != null){
                model.addAttribute("user", user1);
                model.addAttribute("subscribers", followerService.getCountSubscribers(user1.getId()));
                model.addAttribute("subscriptions", followerService.getCountSubscriptions(user1.getId()));
                model.addAttribute("publications", postService.findAllByUserId(user1.getId()) == null? 0: postService.findAllByUserId(user1.getId()).size());
                model.addAttribute("publications", postService.findAllByUserId(user1.getId()).size());
                model.addAttribute("posts", postService.findAllByUserId(user1.getId()));
                model.addAttribute("images", imageService.findAllImageByPosts(postService.findAllByUserId(user1.getId())));
                model.addAttribute("subscribersUser", followerService.getAllSubscribersByUserId(user1.getId()));
                model.addAttribute("subscriptionsUser", followerService.getAllSubscriptionsByUserId(user1.getId()));
                id = user1.getId();
                return "user/user-profile";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "redirect:/instagram.com/login";
    }

    @GetMapping("/signUp")
    public String showRegistrationForm(Model model) {
        model.addAttribute("newUser", new User());
        return "sign-up";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("newUser") User user) {
//         Проверка наличия пользователя с таким же именем
//        if (userService.findById(user.getId()) != null) {
//             Если пользователь с таким именем уже существует, перенаправляем обратно на страницу регистрации с сообщением об ошибке
//            return "redirect:/instagram?error";
//        }
        // Сохраняем пользователя в базу данных с помощью UserService
        userService.saveUser(user);
        // После успешной регистрации перенаправляем пользователя на страницу входа
        return "redirect:/instagram.com/login";
    }


}

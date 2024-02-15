package peaksoft.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.User;
import peaksoft.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/instagram.com/login")
public class RegistrationController {
    private final UserService userService;

    @GetMapping
    public String signIn(Model model){
        model.addAttribute("newUserForSignIn", new User());
        return "sign-in";
    }

//    @PostMapping
//    public String logIn(@ModelAttribute("newUserForSignIn") User user){
//        userService.findByUserName(user);

//        return
//    }

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

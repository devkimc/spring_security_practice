package jwt.practice.app.user.controller;

import jwt.practice.app.user.domain.User;
import jwt.practice.app.user.service.UserService;
import jwt.practice.enums.role.UserRole;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/user")
@Log4j2
public class UserController {

    private final UserService userService;

    @NonNull BCryptPasswordEncoder passwordEncoder;

    @GetMapping(value = "/loginView")
    public String loginView() {
        return "user/login";
    }

    @GetMapping(value = "/init")
    public String createAdmin(@ModelAttribute User user) {
        user.setEmail("user@naver.com");
        user.setPw(passwordEncoder.encode("test"));
        user.setRole(UserRole.ROLE_USER);
        if (userService.createUser(user) == null) {
            log.error("Create User Error");
        }

        user.setEmail("admin@naver.com");
        user.setPw(passwordEncoder.encode("test"));
        user.setRole(UserRole.ROLE_ADMIN);
        if (userService.createUser(user) == null) {
            log.error("Create Admin Error");
        }
        return "redirect:/index";
    }

    @PostMapping(value = "/login")
    public String login(HttpServletRequest request, RedirectAttributes redirectAttributes, @ModelAttribute User user) {
        log.error("@@@");
        String pw = user.getPw();
        user = userService.findUserByEmail(user.getEmail());
        if (user == null || !passwordEncoder.matches(pw, user.getPw())) {
            redirectAttributes.addFlashAttribute("rsMsg", "아이디 또는 비밀번호가 잘못됐습니다.");
            return "redirect:/user/loginView";
        }

        request.getSession().setAttribute("user", user);
        return "redirect:/index";
    }
}

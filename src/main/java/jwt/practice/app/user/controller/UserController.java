package jwt.practice.app.user.controller;

import jwt.practice.app.user.dto.SignUpDTO;
import jwt.practice.app.user.dto.UserListResponseDTO;
import jwt.practice.app.user.service.UserService;
import jwt.practice.utils.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostMapping(value = "/signUp")
    public ResponseEntity<String> signUp(@RequestBody final SignUpDTO signUpDTO) {
        return userService.isEmailDuplicated(signUpDTO.getEmail())
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(TokenUtils.generateJwtToken(userService.signUp(signUpDTO)));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<UserListResponseDTO> findAll() {
        final UserListResponseDTO userListResponseDTO = UserListResponseDTO.builder()
                .userList(userService.findAll()).build();

        return ResponseEntity.ok(userListResponseDTO);
    }
}

package jwt.practice.user.ui;

import jwt.practice.common.ApiResponse;
import jwt.practice.common.DataApiResponse;
import jwt.practice.user.application.UserService;
import jwt.practice.user.application.dto.UserInfoDTO;
import jwt.practice.user.application.dto.UserJoinDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @PostMapping(name = "로그인", value = "/login")
//    public ApiResponse join(@RequestBody UserJoinDTO userJoinDTO) {
//        System.out.println("userJoinDTO = " + userJoinDTO);
//        userService.join(userJoinDTO);
//        return new ApiResponse();
//    }

    @PostMapping(name = "회원가입", value = "/user")
    public ApiResponse join(@RequestBody UserJoinDTO userJoinDTO) {
        System.out.println("userJoinDTO = " + userJoinDTO);
        userService.join(userJoinDTO);
        return new ApiResponse();
    }

    @GetMapping(name = "회원 정보조회", value = "/user/{id}")
    public DataApiResponse<UserInfoDTO> info(@PathVariable long id) {
        System.out.println("id = " + id);
        UserInfoDTO userInfoDTO = userService.getInfo(id);
        System.out.println("userInfoDTO = " + userInfoDTO);
        return new DataApiResponse<>(userInfoDTO);
    }

}

package jwt.practice.app.user.dto;

import jwt.practice.app.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserListResponseDTO {

    private final List<User> userList;
}

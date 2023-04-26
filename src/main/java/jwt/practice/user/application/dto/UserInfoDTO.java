package jwt.practice.user.application.dto;

import lombok.*;

@Builder
@Getter
public class UserInfoDTO {
    private long id;
    private String userId;
    private String email;
    private String name;
}

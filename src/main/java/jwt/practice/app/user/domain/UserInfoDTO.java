package jwt.practice.app.user.domain;

import lombok.*;

@Builder
@Getter
public class UserInfoDTO {
    private long id;
    private String userId;
    private String email;
    private String name;
}

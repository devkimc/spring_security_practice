package jwt.practice;

import lombok.Delegate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@RequiredArgsConstructor
@Getter
public class UserDetailsVO implements UserDetails {

    @Delegate
    private final UserVO loadUser

}

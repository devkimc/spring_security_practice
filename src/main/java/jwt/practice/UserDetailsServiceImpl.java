package jwt.practice;

import jwt.practice.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsVO loadUserByUsername(String userEmail) {
        return userRepository.findByEmail(userEmail)
                .map(user -> new UserDetailsVO(user, Collections.singleton(new SimpleGrantedAuthority(user.getRole().getValue()))))
                .orElseThrow(() -> new UserNotFoundException(userEmail));
    }
}

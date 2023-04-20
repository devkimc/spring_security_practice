package jwt.practice.app.user.service;

import jwt.practice.app.user.domain.User;
import jwt.practice.app.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User login(User user) {
        return userRepository.findByEmailAndPw(user.getEmail(), user.getPw());
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }
}

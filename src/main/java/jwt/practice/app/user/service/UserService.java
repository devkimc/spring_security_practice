package jwt.practice.app.user.service;

public interface UserService {

    User login(User user);

    User createUser(User user);

    User findUserByEmail(String email);
}

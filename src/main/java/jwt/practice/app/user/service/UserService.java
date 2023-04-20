package jwt.practice.app.user.service;

import jwt.practice.app.user.domain.User;

public interface UserService {

    User login(User user);

    User createUser(User user);

    User findUserByEmail(String email);
}

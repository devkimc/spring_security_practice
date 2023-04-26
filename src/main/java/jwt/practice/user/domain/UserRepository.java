package jwt.practice.user.domain;

import jwt.practice.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {


    Optional<User> findFirstUserByLoginOrderByIdAsc(String username);
    Optional<User> findById(long id);
    User save(User saveUser);
}

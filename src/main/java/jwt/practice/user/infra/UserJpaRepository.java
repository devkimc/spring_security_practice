package jwt.practice.user.infra;

import jwt.practice.user.domain.User;
import jwt.practice.user.domain.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long>, UserRepository {
}

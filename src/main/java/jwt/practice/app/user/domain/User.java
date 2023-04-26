package jwt.practice.app.user.domain;

import jwt.practice.app.common.domain.Common;
import jwt.practice.enums.role.UserRole;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(length = 200, nullable = false)
    private String email;

    @Column(nullable = false, length = 50)
    private String name;
}

package com.react.app.persistence.entity;

import com.react.app.persistence.audit.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends AuditableEntity {
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer idUser;
    */

    @Id
    @Column(nullable = false, length = 20, unique = true)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;
    /*
    // @Pattern(regexp = "\\d{7,8}", message = "El DNI debe tener entre 7 y 8 dígitos")
    @Column(nullable = false, length = 15, unique = true)
    private String dni;
    */

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    /*
    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String surname;
    */
    /*
    @Column(length = 15)
    private String role;
    */

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean locked;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean disabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRoleEntity> roles;

}

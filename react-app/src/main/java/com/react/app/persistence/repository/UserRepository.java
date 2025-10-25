package com.react.app.persistence.repository;

import com.react.app.persistence.entity.UserEntity;
import com.react.app.service.dto.UpdateUserPasswordDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<UserEntity, String> {

    /*
    extends ListCrudRepository<UserEntity, Integer>

    @Modifying
    @Query(value =
            "UPDATE user " +
            "SET password = :#{#newUserPassword.newPassword} " +
            "WHERE id_user = :#{#newUserPassword.idUser}", nativeQuery = true)
    void updatePassword(@Param("newUserPassword")UpdateUserPasswordDto newUserPassword);
    */
}

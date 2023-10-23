package org.corrigentia.fitrest.model.vo;

import jakarta.validation.constraints.NotBlank;
import org.corrigentia.fitrest.adal.domain.entity.security.StudentEntity;
import org.corrigentia.fitrest.adal.domain.entity.security.UserEntity;

public class StudentForm {

    @NotBlank
    public String firstName;

    //    @NotBlank
    public String lastName;

    @NotBlank
    public String email;

    @NotBlank
    public String password;


    public StudentEntity toEntity() {
        final StudentEntity entity = new StudentEntity();

        entity.setFirstName(this.firstName);
        entity.setLastName(this.lastName);
        entity.setEmail(this.email);
        entity.setPassword(this.password);

        return entity;
    }
}

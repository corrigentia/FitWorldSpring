package org.corrigentia.fitrest.model.vo;

import jakarta.validation.constraints.NotBlank;
import org.corrigentia.fitrest.adal.domain.entity.security.InstructorEntity;
import org.corrigentia.fitrest.adal.domain.entity.security.StudentEntity;

public class InstructorForm {

    @NotBlank
    public String firstName;

    //    @NotBlank
    public String lastName;

    @NotBlank
    public String email;

    @NotBlank
    public String password;


    public InstructorEntity toEntity() {
        final InstructorEntity entity = new InstructorEntity();

        entity.setFirstName(this.firstName);
        entity.setLastName(this.lastName);
        entity.setEmail(this.email);
        entity.setPassword(this.password);

        return entity;
    }
}

package org.corrigentia.fitrest.model.vo;

import jakarta.validation.constraints.NotBlank;
import org.corrigentia.fitrest.adal.domain.entity.security.AdminEntity;

public class AdminForm {

    @NotBlank
    public String firstName;

    //    @NotBlank
    public String lastName;

    @NotBlank
    public String email;

    @NotBlank
    public String password;


    public AdminEntity toEntity() {
        final AdminEntity entity = new AdminEntity();

        entity.setFirstName(this.firstName);
        entity.setLastName(this.lastName);
        entity.setEmail(this.email);
        entity.setPassword(this.password);

        return entity;
    }
}

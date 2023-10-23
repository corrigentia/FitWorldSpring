package org.corrigentia.fitrest.model.vo;

import jakarta.validation.constraints.NotBlank;
import org.corrigentia.fitrest.adal.domain.entity.security.AdminEntity;
import org.corrigentia.fitrest.adal.domain.entity.security.UserEntity;

public class LoginForm {
    @NotBlank
    public String email;
    @NotBlank
    public String password;

    public UserEntity toEntity() {
        UserEntity user = new AdminEntity();

        user.setEmail(this.email);
        user.setPassword(this.password);

        return user;
    }
}

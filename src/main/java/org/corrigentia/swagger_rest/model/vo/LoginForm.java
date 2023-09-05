package org.corrigentia.swagger_rest.model.vo;

import jakarta.validation.constraints.NotBlank;

public class LoginForm {
    @NotBlank
    public String username;
    @NotBlank
    public String password;
}

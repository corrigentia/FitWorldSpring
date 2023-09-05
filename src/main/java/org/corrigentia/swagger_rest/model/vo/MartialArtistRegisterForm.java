package org.corrigentia.swagger_rest.model.vo;

import jakarta.validation.constraints.NotBlank;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.MartialArtistEntity;

public class MartialArtistRegisterForm {
    @NotBlank
    public String firstName;
    @NotBlank
    public String lastName;
    @NotBlank
    public String username;
    @NotBlank
    public String password;

    public MartialArtistEntity toEntity() {
        MartialArtistEntity entity = new MartialArtistEntity();

        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        entity.setUsername(username);
        entity.setPassword(password);

        return entity;
    }
}

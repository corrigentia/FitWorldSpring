package org.corrigentia.fitrest.model.vo;

import jakarta.validation.constraints.NotBlank;
import org.corrigentia.fitrest.adal.domain.entity.security.MartialArtistEntity;

public class MartialArtistRegisterForm {
    @NotBlank
    public String firstName;
    @NotBlank
    public String lastName;
    @NotBlank
    public String email;
    @NotBlank
    public String password;

    public MartialArtistEntity toEntity() {
        final MartialArtistEntity entity = new MartialArtistEntity();

        entity.setFirstName(this.firstName);
        entity.setLastName(this.lastName);
        entity.setEmail(this.email);
        entity.setPassword(this.password);

        return entity;
    }
}

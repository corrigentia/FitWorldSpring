package org.corrigentia.fitrest.model.vo;

import jakarta.validation.constraints.NotBlank;
import org.corrigentia.fitrest.adal.domain.entity.MartialArtEntity;

public class MartialArtForm {
    @NotBlank
    public String name;


    public MartialArtEntity toEntity() {
        MartialArtEntity entity = new MartialArtEntity();

        entity.setName(name);

        return entity;
    }
}

package org.corrigentia.swagger_rest.model.vo;

import jakarta.validation.constraints.NotBlank;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.MartialArtEntity;

public class MartialArtForm {
    @NotBlank
    public String name;


    public MartialArtEntity toEntity() {
        MartialArtEntity entity = new MartialArtEntity();

        entity.setName(name);

        return entity;
    }
}

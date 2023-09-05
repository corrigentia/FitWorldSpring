package org.corrigentia.swagger_rest.model.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.EquipmentEntity;

public class EquipmentForm {
    @NotBlank
    public String name;

    @Positive
    public double price;

    public EquipmentEntity toEntity() {
        EquipmentEntity entity = new EquipmentEntity();

        entity.setName(name);
        entity.setPrice(price);

        return entity;
    }
}

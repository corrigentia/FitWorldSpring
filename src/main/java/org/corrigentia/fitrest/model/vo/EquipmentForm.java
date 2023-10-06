package org.corrigentia.fitrest.model.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.corrigentia.fitrest.adal.domain.entity.EquipmentEntity;

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

package org.corrigentia.fitrest.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import org.corrigentia.fitrest.adal.domain.entity.EquipmentEntity;

@Data
@Builder
public class EquipmentBll {
    private long id;
    private String name;
    private double price;

    public static EquipmentBll fromEntity(EquipmentEntity entity) {
        return new EquipmentBllBuilder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .build();
    }

    public EquipmentEntity toEntity() {
        EquipmentEntity entity = new EquipmentEntity();

        entity.setId(this.id);
        entity.setName(this.name);
        entity.setPrice(this.price);

        return entity;
    }
}

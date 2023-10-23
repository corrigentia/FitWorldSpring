package org.corrigentia.fitrest.model.vo;

import lombok.Builder;
import org.corrigentia.fitrest.adal.domain.entity.EquipmentEntity;
import org.corrigentia.fitrest.adal.domain.entity.EquipmentOwnedEntity;

@Builder
public class EquipmentOwnedVO {

    private long id;
    private int quantity;
    private EquipmentEntity equipment;

    public static EquipmentOwnedVO fromBLL(EquipmentOwnedEntity bll) {
        EquipmentOwnedVO.EquipmentOwnedVOBuilder builder =
                new EquipmentOwnedVOBuilder()
                        .id(bll.getId())
                        .quantity(bll.getQuantity())
                        .equipment(bll.getEquipment());

        return builder.build();
    }
}

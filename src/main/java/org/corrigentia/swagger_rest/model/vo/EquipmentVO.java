package org.corrigentia.swagger_rest.model.vo;

import lombok.Builder;
import lombok.Getter;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.EquipmentEntity;

@Builder
@Getter
public class EquipmentVO {
    private long id;
    private String name;
    private double price;

    public static EquipmentVO fromBLL(EquipmentEntity bll) {
        EquipmentVO.EquipmentVOBuilder builder =
                new EquipmentVO.EquipmentVOBuilder()
                        .id(bll.getId())
                        .name(bll.getName())
                        .price(bll.getPrice());

        return builder.build();
    }
}

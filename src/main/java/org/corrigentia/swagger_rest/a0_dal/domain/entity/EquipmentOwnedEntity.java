package org.corrigentia.swagger_rest.a0_dal.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "equipment_owned")
@Data
public class EquipmentOwnedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "equipment_id", nullable = false)
    private EquipmentEntity equipment;

}

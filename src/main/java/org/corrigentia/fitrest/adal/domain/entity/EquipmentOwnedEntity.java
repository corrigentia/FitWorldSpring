package org.corrigentia.fitrest.adal.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = EquipmentOwnedEntity.TABLE_NAME, uniqueConstraints = @UniqueConstraint(name = "uc_equipment_owned", columnNames = {"quantity", "equipment_id"}))
@Data
public class EquipmentOwnedEntity {
    public static final String TABLE_NAME = "equipment_owned";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "equipment_id", nullable = false)
    private EquipmentEntity equipment;

}

package org.corrigentia.fitrest.adal.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = EquipmentEntity.TABLE_NAME, uniqueConstraints = @UniqueConstraint(name = "uc_equipment_name_price", columnNames = {"name", "price"}))
@Data
public class EquipmentEntity extends Deletable {

    public static final String TABLE_NAME = "equipment";
    public static final String COLUMN_ID_NAME = "id";

    @Positive
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = EquipmentEntity.COLUMN_ID_NAME, nullable = false)
    private Long id;

    private String name;
    private double price;
}

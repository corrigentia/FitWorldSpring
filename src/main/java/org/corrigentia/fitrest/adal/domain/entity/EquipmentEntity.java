package org.corrigentia.fitrest.adal.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@ToString(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = EquipmentEntity.TABLE_NAME, uniqueConstraints = @UniqueConstraint(name = "uc_equipment_name_price", columnNames = {"name", "price"}))
@RequiredArgsConstructor
@AllArgsConstructor
public class EquipmentEntity extends Deletable {

    public static final String TABLE_NAME = "equipment";
    public static final String COLUMN_ID_NAME = "id";

    @Positive
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = EquipmentEntity.COLUMN_ID_NAME, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    public EquipmentEntity(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        EquipmentEntity entity = (EquipmentEntity) o;
        return getId() != null && Objects.equals(getId(), entity.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}

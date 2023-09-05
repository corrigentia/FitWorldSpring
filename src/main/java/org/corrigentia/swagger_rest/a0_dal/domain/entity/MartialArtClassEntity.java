package org.corrigentia.swagger_rest.a0_dal.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.InstructorEntity;

@Getter
@Setter
@Entity
@Table(name = MartialArtClassEntity.TABLE_NAME)
@Data
public class MartialArtClassEntity extends Deletable {

    public static final String COLUMN_DATETIME_NAME = "date_time";
    public static final String TABLE_NAME = "martial_art_class";
    public static final String COLUMN_PRICEPERHOUR_NAME = "price_per_hour";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "martial_art_id", nullable = false)
    private MartialArtEntity martialArt;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "instructor_id", nullable = false)
    private InstructorEntity instructor;

    @NotNull
    @Column(name = COLUMN_DATETIME_NAME, nullable = false)
    private LocalDateTime dateTime;

    @Positive
    @Column(name = COLUMN_PRICEPERHOUR_NAME, nullable = false)
    private double pricePerHour;

}

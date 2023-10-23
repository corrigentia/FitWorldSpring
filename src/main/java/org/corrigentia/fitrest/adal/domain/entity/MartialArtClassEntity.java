package org.corrigentia.fitrest.adal.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.corrigentia.fitrest.adal.domain.entity.security.InstructorEntity;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = MartialArtClassEntity.TABLE_NAME, uniqueConstraints = @UniqueConstraint(name = "uc_martial_art_class", columnNames = {
        "instructor_id", "date_time"}))
@Data
// @JavaBean // didn't solve @Inject/@AutoWired martialArtClassEntity
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
    @Column(name = MartialArtClassEntity.COLUMN_DATETIME_NAME, nullable = false)

    private LocalDateTime dateTime;

    @Positive
    @Column(name = MartialArtClassEntity.COLUMN_PRICEPERHOUR_NAME, nullable = false)
    private double pricePerHour;

}

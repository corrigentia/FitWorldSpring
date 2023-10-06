package org.corrigentia.fitrest.adal.domain.entity;

import java.time.LocalDateTime;

import org.corrigentia.fitrest.adal.domain.entity.security.InstructorEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = MartialArtClassEntity.TABLE_NAME, uniqueConstraints = @UniqueConstraint(name = "uc_martial_art_class", columnNames = {
        "instructor_id", "date_time" }))
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

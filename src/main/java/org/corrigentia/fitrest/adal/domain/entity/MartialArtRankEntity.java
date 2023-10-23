package org.corrigentia.fitrest.adal.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = MartialArtRankEntity.TABLE_NAME, uniqueConstraints = @UniqueConstraint(name = "uc_martial_art_rank", columnNames = {"martial_art_id", "rank_id"}))
@Data
public class MartialArtRankEntity extends Deletable {

    public static final String TABLE_NAME = "martial_art_rank";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rank_id")
    private RankEntity rank;

    @ManyToOne
    @JoinColumn(name = "martial_art_id")
    private MartialArtEntity martialArt;


}

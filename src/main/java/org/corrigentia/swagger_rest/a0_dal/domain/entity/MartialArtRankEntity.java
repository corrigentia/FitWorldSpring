package org.corrigentia.swagger_rest.a0_dal.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "martial_art_rank")
@Data
public class MartialArtRankEntity extends Deletable {

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

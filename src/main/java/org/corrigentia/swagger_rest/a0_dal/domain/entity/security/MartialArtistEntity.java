package org.corrigentia.swagger_rest.a0_dal.domain.entity.security;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.EquipmentOwnedEntity;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.MartialArtRankEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = MartialArtistEntity.ENTITY_NAME)
// @Table(name = "martial_artist", schema = "fit_world")
@Data
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MartialArtistEntity extends UserEntity {
    public static final String JOINTABLE_OWNEDEQUIPMENTS_NAME = "martial_artist_owned_equipment";
    public static final String JOINCOLUMNS_JOINCOLUMN_OWNEDEQUIPMENTS_NAME = "martial_artist_id";
    public static final String INVERSEJOINCOLUMNS_JOINCOLUMN_OWNEDEQUIPMENTS_NAME = "owned_equipment_id";
    public static final String ENTITY_NAME = "MartialArtist";
    public static final String JOINTABLE_RANKS_NAME = "martial_artist_ranks";
    public static final String JOINCOLUMNS_JOINCOLUMN_RANKS_NAME = "martial_artist_id";
    public static final String INVERSEJOINCOLUMNS_JOINCOLUMN_RANKS_NAME = "rank_id";


    @ManyToMany
    @JoinTable(name = MartialArtistEntity.JOINTABLE_OWNEDEQUIPMENTS_NAME, joinColumns = @JoinColumn(name = MartialArtistEntity.JOINCOLUMNS_JOINCOLUMN_OWNEDEQUIPMENTS_NAME), inverseJoinColumns = @JoinColumn(name = MartialArtistEntity.INVERSEJOINCOLUMNS_JOINCOLUMN_OWNEDEQUIPMENTS_NAME))
    private Set<EquipmentOwnedEntity> ownedEquipments = new HashSet<>(35);

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @ManyToMany
    @JoinTable(name = JOINTABLE_RANKS_NAME, joinColumns = @JoinColumn(name = JOINCOLUMNS_JOINCOLUMN_RANKS_NAME), inverseJoinColumns = @JoinColumn(name = INVERSEJOINCOLUMNS_JOINCOLUMN_RANKS_NAME))
    private Set<MartialArtRankEntity> ranks = new LinkedHashSet<>(20);

}

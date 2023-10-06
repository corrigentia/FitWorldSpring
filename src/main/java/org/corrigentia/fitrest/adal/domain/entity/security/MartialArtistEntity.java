package org.corrigentia.fitrest.adal.domain.entity.security;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.corrigentia.fitrest.adal.domain.entity.EquipmentOwnedEntity;
import org.corrigentia.fitrest.adal.domain.entity.MartialArtRankEntity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = MartialArtistEntity.ENTITY_NAME)
@Table(uniqueConstraints = @UniqueConstraint(name = "uc_martial_artist", columnNames = {"firstName", "lastName"}), name = MartialArtistEntity.TABLE_NAME1)
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
    public static final String TABLE_NAME1 = "MartialArtist";
    @ManyToMany
    @JoinTable(name = MartialArtistEntity.JOINTABLE_OWNEDEQUIPMENTS_NAME, joinColumns = @JoinColumn(name = MartialArtistEntity.JOINCOLUMNS_JOINCOLUMN_OWNEDEQUIPMENTS_NAME), inverseJoinColumns = @JoinColumn(name = MartialArtistEntity.INVERSEJOINCOLUMNS_JOINCOLUMN_OWNEDEQUIPMENTS_NAME))
    private Set<EquipmentOwnedEntity> ownedEquipments = new HashSet<>(35);
    @Column(nullable = false)
    private String firstName;
    //    @Column(nullable = false)
    @Column(nullable = true)
    private String lastName;
    @ManyToMany
    @JoinTable(name = JOINTABLE_RANKS_NAME, joinColumns = @JoinColumn(name = JOINCOLUMNS_JOINCOLUMN_RANKS_NAME), inverseJoinColumns = @JoinColumn(name = INVERSEJOINCOLUMNS_JOINCOLUMN_RANKS_NAME))
    private Set<MartialArtRankEntity> ranks = new LinkedHashSet<>(20);

    public Set<EquipmentOwnedEntity> getOwnedEquipments() {
        return Set.copyOf(ownedEquipments);
    }

    public Set<MartialArtRankEntity> getRanks() {
        return Set.copyOf(ranks);
    }

    public void addOwnedEquipment(EquipmentOwnedEntity equipmentOwned) {
        this.ownedEquipments.add(equipmentOwned);
    }

    public void addRank(MartialArtRankEntity martialArtRank) {
        this.ranks.add(martialArtRank);
    }


    public void removeOwnedEquipment(EquipmentOwnedEntity equipmentOwned) {
        this.ownedEquipments.remove(equipmentOwned);
    }

    public void removeRank(MartialArtRankEntity martialArtRank) {
        this.ranks.remove(martialArtRank);
    }


}

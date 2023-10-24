package org.corrigentia.fitrest.adal.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@ToString(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = MartialArtRankEntity.TABLE_NAME, uniqueConstraints = @UniqueConstraint(name = "uc_martial_art_rank", columnNames = {"martial_art_id", "rank_id"}))
@RequiredArgsConstructor
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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        MartialArtRankEntity that = (MartialArtRankEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}

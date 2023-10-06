package org.corrigentia.fitrest.adal.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = RankEntity.TABLE_NAME)
@Data
public class RankEntity extends Deletable {

    public static final String TABLE_NAME = "rank";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String rankName;

}

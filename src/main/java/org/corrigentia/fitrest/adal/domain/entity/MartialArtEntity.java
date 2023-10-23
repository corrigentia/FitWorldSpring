package org.corrigentia.fitrest.adal.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = MartialArtEntity.TABLE_NAME)
public class MartialArtEntity extends Deletable {

    public static final String TABLE_NAME = "martial_art";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String name;

}

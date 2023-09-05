package org.corrigentia.swagger_rest.a0_dal.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rank")
@Data
public class RankEntity extends Deletable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String rank;

}

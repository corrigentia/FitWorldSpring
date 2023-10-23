package org.corrigentia.fitrest.adal.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@MappedSuperclass
//@Getter(AccessLevel.PROTECTED)
@Getter
//@Setter(AccessLevel.PROTECTED)
@Setter
//@ToString(of = {"id"}, callSuper = true)
@ToString(callSuper = true)
@RequiredArgsConstructor
@EntityListeners(value = {AuditingEntityListener.class})
//@Inheritance()
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AuditingBaseEntity extends Deletable {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // must be GenerationType.TABLE for InheritanceType.TABLE_PER_CLASS
//    @GeneratedValue(strategy = GenerationType.TABLE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ToString.Include
    private Long id;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate updatedAt;

}

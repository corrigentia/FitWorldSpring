package org.corrigentia.swagger_rest.a0_dal.domain.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
//@Getter(AccessLevel.PROTECTED)
@Getter
//@Setter(AccessLevel.PROTECTED)
@Setter
@ToString
@RequiredArgsConstructor
@EntityListeners(value = { AuditingEntityListener.class })
//@Inheritance()
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AuditingBaseEntity extends Deletable {

	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	// must be GenerationType.TABLE for InheritanceType.TABLE_PER_CLASS
//    @GeneratedValue(strategy = GenerationType.TABLE)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@CreatedDate
	private LocalDate createdAt;

	@LastModifiedDate
	private LocalDate updatedAt;

}

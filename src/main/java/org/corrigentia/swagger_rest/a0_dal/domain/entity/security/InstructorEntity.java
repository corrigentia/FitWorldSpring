package org.corrigentia.swagger_rest.a0_dal.domain.entity.security;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "Instructor")
// @Table(name = "instructor")
@Data
public class InstructorEntity extends MartialArtistEntity {
}

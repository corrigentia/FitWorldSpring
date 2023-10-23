package org.corrigentia.fitrest.adal.domain.entity.security;

import jakarta.persistence.Entity;
import lombok.ToString;

@ToString(callSuper = true)
@Entity(name = "admin")
public class AdminEntity extends UserEntity {
}

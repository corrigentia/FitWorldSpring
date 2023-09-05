package org.corrigentia.swagger_rest.model.vo;

import lombok.Builder;
import lombok.Getter;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.EquipmentOwnedEntity;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.InstructorEntity;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

@Builder
@Getter
public class InstructorVO {
    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Set<EquipmentOwnedEntity> ownedEquipments;
    private Collection<? extends GrantedAuthority> authorities;

    public static InstructorVO fromBLL(InstructorEntity bll) {
        InstructorVO.InstructorVOBuilder builder =
                new InstructorVOBuilder()
                        .id(bll.getId())
                        .firstName(bll.getFirstName())
                        .lastName(bll.getLastName())
                        .username(bll.getUsername())
                        .password(bll.getPassword())
                        .createdAt(bll.getCreatedAt())
                        .updatedAt(bll.getUpdatedAt())
                        .ownedEquipments(bll.getOwnedEquipments())
                        .authorities(bll.getAuthorities());

        return builder.build();
    }
}

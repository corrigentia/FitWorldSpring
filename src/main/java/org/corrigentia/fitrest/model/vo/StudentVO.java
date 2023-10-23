package org.corrigentia.fitrest.model.vo;

import lombok.Builder;
import lombok.Getter;
import org.corrigentia.fitrest.adal.domain.entity.EquipmentOwnedEntity;
import org.corrigentia.fitrest.adal.domain.entity.security.StudentEntity;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Getter
public class StudentVO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Set<EquipmentOwnedEntity> ownedEquipments;
    private Collection<? extends GrantedAuthority> authorities;
    private Set<MartialArtClassVO> classesTaken;

    public static StudentVO fromBLL(StudentEntity bll) {
        StudentVO.StudentVOBuilder builder = new StudentVOBuilder()
                .id(bll.getId())
                .firstName(bll.getFirstName())
                .lastName(bll.getLastName())
                .email(bll.getUsername())
                .password(bll.getPassword())
                .createdAt(bll.getCreatedAt())
                .updatedAt(bll.getUpdatedAt())
                .ownedEquipments(bll.getOwnedEquipments())
                .authorities(bll.getAuthorities())
                .classesTaken(
                        bll.getClassesTaken().stream()
                                .map(MartialArtClassVO::fromBLL)
                                .collect(Collectors.toSet()));

        return builder.build();
    }
}

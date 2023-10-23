package org.corrigentia.fitrest.model.vo;

import lombok.Builder;
import lombok.Getter;
import org.corrigentia.fitrest.adal.domain.entity.security.AdminEntity;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.Collection;

@Builder
@Getter
public class AdminVO {
    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Collection<? extends GrantedAuthority> authorities;

    public static AdminVO fromBLL(AdminEntity bll) {
        AdminVO.AdminVOBuilder builder =
                new AdminVO.AdminVOBuilder()
                        .id(bll.getId())
                        .firstName(bll.getFirstName())
                        .lastName(bll.getLastName())
                        .username(bll.getUsername())
                        .password(bll.getPassword())
                        .createdAt(bll.getCreatedAt())
                        .updatedAt(bll.getUpdatedAt())
                        .authorities(bll.getAuthorities());

        return builder.build();
    }
}

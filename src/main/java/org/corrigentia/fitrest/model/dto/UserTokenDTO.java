package org.corrigentia.fitrest.model.dto;

import lombok.Data;
import org.corrigentia.fitrest.adal.domain.entity.security.RoleType;
import org.corrigentia.fitrest.adal.domain.entity.security.UserEntity;

/**
 * @author Person
 * @since 2023/08/11
 */
@Data
public class UserTokenDTO {
    private Long id;
    private String email;
    private RoleType role;
    private String token;

    public static UserTokenDTO fromEntity(UserEntity user) {
        UserTokenDTO dto = new UserTokenDTO();

        dto.setId(user.getId());
        dto.setEmail(user.getUsername());
        dto.setRole(user.getRole());

        return dto;
    }
}

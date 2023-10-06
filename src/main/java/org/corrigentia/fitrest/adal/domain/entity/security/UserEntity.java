package org.corrigentia.fitrest.adal.domain.entity.security;

import jakarta.persistence.*;
import lombok.*;
import org.corrigentia.fitrest.adal.domain.entity.AuditingBaseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true, of = {"id", "email", "role"})
@Setter
@Entity(name = UserEntity.ENTITY_NAME)
@Table(name = UserEntity.TABLE_NAME)
@ToString(of = {"id", "email", "role"})
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserEntity extends AuditingBaseEntity implements UserDetails {
    public static final String ENTITY_NAME = "User";
    public static final String TABLE_NAME = "security_user";
    public static final String COLUMN_ROLE_NAME = "role";

    @Setter
    @Column(unique = true, nullable = false, length = 150)
    private String email;

    @Getter
    @Setter
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = COLUMN_ROLE_NAME, nullable = false)
    @Getter
    @Setter
    private RoleType role;

    /**
     * Returns the authorities granted to the user. Cannot return {@code null}.
     *
     * @return the authorities, sorted by natural key (never {@code null})
     */
    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
        final List<String> authorities = List.of("ROLE_USER");

        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
        */
        final List<GrantedAuthority> authorities = new ArrayList<>(20);
        GrantedAuthority authority =
                new SimpleGrantedAuthority(this.role.toString());

        authorities.add(authority);
        return authorities;
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * Returns the username used to authenticate the user. Cannot return
     * {@code null}.
     *
     * @return the username (never {@code null})
     */
    @Override
    public String getUsername() {
        return this.email;
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     *
     * @return {@code true} if the user's account is valid (ie non-expired),
     * {@code false} if no longer valid (ie expired)
     */
    @Transient
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     *
     * @return {@code true} if the user is not locked, <code>false</code> otherwise
     */
    @Transient
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return {@code true} if the user's credentials are valid (ie non-expired),
     * {@code false} if no longer valid (ie expired)
     */
    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is enabled, {@code false} otherwise
     */
    @Transient
    @Override
    public boolean isEnabled() {
        return true;
    }
}

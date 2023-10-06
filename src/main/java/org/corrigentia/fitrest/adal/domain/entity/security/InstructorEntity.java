package org.corrigentia.fitrest.adal.domain.entity.security;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(name = "Instructor")
// @Table(name = "instructor")
@Data
public class InstructorEntity extends MartialArtistEntity {

//    Might as well remove the method & then the class now

    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
        List<String> authorities = List.of("ROLE_INSTRUCTOR");

        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
        */

        List<GrantedAuthority> authorities = new ArrayList<>(20);
        GrantedAuthority authority =
                new SimpleGrantedAuthority(this.getRole().toString());
        authorities.add(authority);
        return authorities;
    }

}

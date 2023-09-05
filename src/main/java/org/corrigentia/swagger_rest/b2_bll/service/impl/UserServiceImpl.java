package org.corrigentia.swagger_rest.b2_bll.service.impl;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.UserEntity;
import org.corrigentia.swagger_rest.a0_dal.repo.UserRepository;
import org.corrigentia.swagger_rest.b2_bll.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service // this messed up UserService, which messed up SecurityController,
// which messed up the whole app...
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public UserDetails insert(final UserEntity entity) {
        return this.userRepository.save(entity);
    }

    /**
     * Locates the user based on the username. In the actual implementation, the
     * search may be case-sensitive, or case-insensitive depending on how
     * the implementation instance is configured. In this case, the
     * <code>UserDetails</code> object that comes back may have a username that is
     * of a different case than what was actually requested.
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user
     *                                   has no GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " " + "not found"));
    }
}

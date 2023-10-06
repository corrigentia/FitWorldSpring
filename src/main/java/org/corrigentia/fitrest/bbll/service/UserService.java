package org.corrigentia.fitrest.bbll.service;

import org.corrigentia.fitrest.adal.domain.entity.security.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

/**
 * @author Person
 * @since 2023/08/11
 */
//@Service
//@Transactional(rollbackFor = Exception.class)
//public class UserService {
public interface UserService extends UserDetailsService {
//    @Autowired
//    private UserManager manager;

//    UserDetails insert(UserEntity entity);

    UserEntity register(UserEntity user);

    UserEntity signIn(UserEntity user);

//    UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
}

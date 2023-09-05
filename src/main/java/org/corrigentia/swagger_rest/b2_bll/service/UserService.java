package org.corrigentia.swagger_rest.b2_bll.service;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
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

    UserDetails insert(UserEntity entity);
}

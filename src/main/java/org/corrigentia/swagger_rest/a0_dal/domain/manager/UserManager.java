package org.corrigentia.swagger_rest.a0_dal.domain.manager;

import lombok.extern.slf4j.Slf4j;
import org.corrigentia.swagger_rest.a0_dal.domain.Factory;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.User;
import org.corrigentia.swagger_rest.a0_dal.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Person
 * @since 2023/08/11
 */
@Slf4j
@Component
public class UserManager {
    @Autowired
    private Factory factory;
    @Autowired
    private UserRepository repository;

    public User get(Long id) {
        // @todo build model
        return null;
    }
}

package org.corrigentia.fitrest.adal.domain.manager;

import lombok.extern.slf4j.Slf4j;
import org.corrigentia.fitrest.adal.domain.Factory;
import org.corrigentia.fitrest.adal.domain.entity.User;
import org.corrigentia.fitrest.adal.repo.UserRepository;
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

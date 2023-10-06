package org.corrigentia.fitrest.adal.domain.entity;

import org.corrigentia.fitrest.adal.repo.UserRepository;

/**
 * @author Person
 * @since 2023/08/11
 */
public class User extends BaseEntity<Long, UserRepository> {

    public User(Long id, UserRepository repo) {
        super(id, repo);
    }

//    public UserDO data() {
//        return getRepo().selectById(getId());
//    }
}

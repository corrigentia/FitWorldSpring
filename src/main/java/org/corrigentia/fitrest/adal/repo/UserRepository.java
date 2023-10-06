package org.corrigentia.fitrest.adal.repo;

import org.corrigentia.fitrest.adal.domain.entity.security.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author Person
 * @since 2023/08/11
 */
//@Repository // its presence messed up the app, so keep it commented out !!!
//@Slf4j
//public class UserRepository {
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // @Query("select u from User u where u.username = ?1")
//    Optional<UserEntity> findByUsername(String username);
    // messed up the app starting
    /*
    @Query("select u from User u where u.username = :username")
    Optional<UserEntity> findByUsername(@Param("username") String username);
    */

    @Query("select u from User u where u.email = :email")
    Optional<UserEntity> findByEmail(@Param("email") String email);

    boolean existsByEmail(String email);


    // @Autowired
//    private UserMapper mapper;

    /*
     * public UserDO selectById(Long id) { // return mapper.selectById(id); return
     * new UserDO(); }
     *
     * public void update(Long id, UserDO entity) { entity.setId(id); //
     * mapper.updateById(entity); }
     *
     * public Long insert(UserDO entity) { // mapper.insert(entity); return
     * entity.getId(); }
     *
     * public void delete(Long id) { // mapper.deleteById(id); }
     */
}

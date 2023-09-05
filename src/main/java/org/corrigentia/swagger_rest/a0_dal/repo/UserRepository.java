package org.corrigentia.swagger_rest.a0_dal.repo;

import java.util.Optional;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Person
 * @since 2023/08/11
 */
@Repository
//@Slf4j
//public class UserRepository {
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	// @Query("select u from User u where u.username = ?1")
//    Optional<UserEntity> findByUsername(String username);
	@Query("select u from User u where u.username = :username")
	Optional<UserEntity> findByUsername(@Param("username") String username);
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

package org.corrigentia.fitrest.bbll.service.impl;

import org.corrigentia.fitrest.adal.domain.entity.security.RoleType;
import org.corrigentia.fitrest.adal.domain.entity.security.UserEntity;
import org.corrigentia.fitrest.adal.repo.AdminRepository;
import org.corrigentia.fitrest.adal.repo.InstructorRepository;
import org.corrigentia.fitrest.adal.repo.StudentRepository;
import org.corrigentia.fitrest.adal.repo.UserRepository;
import org.corrigentia.fitrest.bbll.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service // this messed up UserService, which messed up SecurityController,
// which messed up the whole app...
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminRepository adminRepository;
    private final InstructorRepository instructorRepository;
    private final StudentRepository studentRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AdminRepository adminRepository, InstructorRepository instructorRepository, StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.adminRepository = adminRepository;
        this.instructorRepository = instructorRepository;
        this.studentRepository = studentRepository;
    }

    /*
    @Override
    public UserDetails insert(UserEntity entity) {
        return userRepository.save(entity);
    }
    */


    /**
     * Locates the user based on the username. In the actual implementation, the
     * search may be case-sensitive, or case-insensitive depending on how
     * the implementation instance is configured. In this case, the
     * {@code UserDetails} object that comes back may have a username that is
     * of a different case than what was actually requested.
     *
     * @param email the username identifying the user whose data is required.
     * @return a fully populated user record (never {@code null})
     * @throws UsernameNotFoundException if the user could not be found or the user
     *                                   has no GrantedAuthority
     */
    /*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " " + "not found"));
    }
    */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("E-mail not registered"));
    }

    @Override
    public UserEntity register(UserEntity user) {
        if (userRepository.existsByEmail(user.getUsername())) {
            throw new RuntimeException("E-mail already taken");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole(RoleType.USER);
        return userRepository.save(user);
    }

    @Override
    public UserEntity signIn(UserEntity user) {
        UserEntity existingUser =
                userRepository.findByEmail(user.getUsername()).orElseThrow(() -> new RuntimeException("wrong username"));
        if (passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            throw new RuntimeException("Wrong password");
        }
        return existingUser;
    }
}

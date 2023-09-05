package org.corrigentia.swagger_rest.c3_pl.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.MartialArtistEntity;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.StudentEntity;
import org.corrigentia.swagger_rest.b2_bll.service.UserService;
import org.corrigentia.swagger_rest.c3_pl.utils.JwtUtil;
import org.corrigentia.swagger_rest.model.vo.AuthResponse;
import org.corrigentia.swagger_rest.model.vo.LoginForm;
import org.corrigentia.swagger_rest.model.vo.MartialArtistRegisterForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin // (origins = { "http://localhost:4200" })
public class SecurityController {
    private final JwtUtil util;
    private final PasswordEncoder passwordEncoder;
    private final UserService securityService;

    public SecurityController(final JwtUtil util, final PasswordEncoder passwordEncoder,
                              final UserService securityService) {
        this.util = util;
        this.passwordEncoder = passwordEncoder;
        this.securityService = securityService;
    }

    // @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
    @GetMapping(path = {"/register"})
//    public ResponseEntity<AuthResponse> getRegisterAction(@RequestBody LoginForm form) {
    public ResponseEntity<AuthResponse> getRegisterAction(@RequestBody final MartialArtistRegisterForm form) {
//        return ResponseEntity.ok(null);
//        UserEntity entity = new UserEntity();
        final MartialArtistEntity entity = new MartialArtistEntity();

        entity.setFirstName(form.firstName);
        entity.setLastName(form.lastName);

        entity.setUsername(form.username);
        entity.setPassword(this.passwordEncoder.encode(form.password));

//        entity.setCreatedAt(LocalDate.now());

        final UserDetails user = this.securityService.insert(entity);
        return ResponseEntity.ok(new AuthResponse(this.util.generateToken(user), user));
    }

    @PostMapping(path = {"/register"})
    public ResponseEntity<AuthResponse>
//    registerAction(@RequestBody LoginForm form) {
    registerAction(@RequestBody final MartialArtistRegisterForm form) {
//        return ResponseEntity.ok(null);
//        UserEntity entity = new UserEntity();
        // final MartialArtistEntity entity = new MartialArtistEntity();
        final StudentEntity entity = new StudentEntity();

        entity.setFirstName(form.firstName);
        entity.setLastName(form.lastName);

//        entity.setCreatedAt(LocalDate.now());

        entity.setUsername(form.username);
        entity.setPassword(this.passwordEncoder.encode(form.password));

        final UserDetails user = this.securityService.insert(entity);
        return ResponseEntity.ok(new AuthResponse(this.util.generateToken(user), user));
    }

    @PostMapping(path = {"/signIn"})
    public ResponseEntity<AuthResponse> signInAction(final HttpServletRequest request,
                                                     @RequestBody final LoginForm form) {
        System.out.println(request);
        final UserDetails user = this.securityService.loadUserByUsername(form.username);

        if (this.passwordEncoder.matches(form.password, user.getPassword())) {

            return ResponseEntity.ok(new AuthResponse(this.util.generateToken(user), user));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
}

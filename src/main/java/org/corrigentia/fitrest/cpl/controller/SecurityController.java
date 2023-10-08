package org.corrigentia.fitrest.cpl.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.corrigentia.fitrest.adal.domain.entity.security.MartialArtistEntity;
import org.corrigentia.fitrest.adal.domain.entity.security.StudentEntity;
import org.corrigentia.fitrest.adal.domain.entity.security.UserEntity;
import org.corrigentia.fitrest.bbll.service.UserService;
import org.corrigentia.fitrest.cpl.utils.JwtUtil;
import org.corrigentia.fitrest.model.dto.UserTokenDTO;
import org.corrigentia.fitrest.model.vo.LoginForm;
import org.corrigentia.fitrest.model.vo.MartialArtistRegisterForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin // (origins = { "http://localhost:4200" })
public class SecurityController {
    private final JwtUtil util;
    private final PasswordEncoder passwordEncoder;
    private final UserService securityService;

    public SecurityController(JwtUtil util, PasswordEncoder passwordEncoder,
                              UserService securityService) {
        this.util = util;
        this.passwordEncoder = passwordEncoder;
        this.securityService = securityService;
    }

    // @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
    @GetMapping(path = "/register")
//    public ResponseEntity<AuthResponse> getRegisterAction(@RequestBody LoginForm form) {
//    public ResponseEntity<AuthResponse> getRegisterAction(@RequestBody MartialArtistRegisterForm form) {
    public ResponseEntity<UserTokenDTO> getRegisterAction(@RequestBody MartialArtistRegisterForm form) {
//        return ResponseEntity.ok(null);
//        UserEntity entity = new UserEntity();
        MartialArtistEntity entity = new MartialArtistEntity();

        entity.setFirstName(form.firstName);
        entity.setLastName(form.lastName);

        entity.setEmail(form.email);
        entity.setPassword(passwordEncoder.encode(form.password));

//        entity.setCreatedAt(LocalDate.now());

//        UserDetails user = securityService.insert(entity);
//        return ResponseEntity.ok(new AuthResponse(util.generateToken(user), user));

        UserEntity user = securityService.register(form.toEntity());
        UserTokenDTO dto = UserTokenDTO.fromEntity(user);
        String token = util.generateToken(user);
        dto.setToken(token);
        return ResponseEntity.ok(dto);
    }

    @PostMapping(path = "/register")
//    public ResponseEntity<AuthResponse>
    public ResponseEntity<UserTokenDTO>
//    registerAction(@RequestBody LoginForm form) {
    registerAction(@RequestBody MartialArtistRegisterForm form) {
//        return ResponseEntity.ok(null);
//        UserEntity entity = new UserEntity();
        // final MartialArtistEntity entity = new MartialArtistEntity();
        StudentEntity entity = new StudentEntity();

        entity.setFirstName(form.firstName);
        entity.setLastName(form.lastName);

//        entity.setCreatedAt(LocalDate.now());

        entity.setEmail(form.email);
        entity.setPassword(passwordEncoder.encode(form.password));

//        UserDetails user = securityService.insert(entity);
//        return ResponseEntity.ok(new AuthResponse(util.generateToken(user), user));


        UserEntity user = securityService.register(form.toEntity());
        UserTokenDTO dto = UserTokenDTO.fromEntity(user);
        String token = util.generateToken(user);
        dto.setToken(token);
        return ResponseEntity.ok(dto);
    }

    @PostMapping(path = "/signIn")
//    public ResponseEntity<AuthResponse> signInAction(HttpServletRequest request,
    public ResponseEntity<UserTokenDTO> signInAction(HttpServletRequest request,
                                                     @RequestBody LoginForm form) {


        System.out.println("trying to sign in");
        System.out.println(request);
//        UserDetails user = securityService.loadUserByUsername(form.email);
        UserEntity user = (UserEntity) securityService.loadUserByUsername(form.email);

//        UserEntity user=securityService.signIn(form.toEntity());


        if (passwordEncoder.matches(form.password, user.getPassword())) {

//            return ResponseEntity.ok(new AuthResponse(util.generateToken(user), user));


            UserTokenDTO dto = UserTokenDTO.fromEntity(user);
            String token = util.generateToken(user);
            dto.setToken(token);
            return ResponseEntity.ok(dto);

        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
}

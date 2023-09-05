package org.corrigentia.swagger_rest.c3_pl.config;

import org.corrigentia.swagger_rest.c3_pl.config.jwt.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    /*
     * @Bean public AuthenticationManager
     * authenticationManager(AuthenticationManagerBuilder auth) throws Exception{
     * return auth .build(); }
     */
    @Bean
    public SecurityFilterChain httpSecurity(final HttpSecurity http, final JwtFilter jwtFilter) throws Exception {
        http
                // .cors(CorsConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable).csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            // this is a must for Angular v14+ because it sends preflight with http method
                            // options and spring security blocks it by default
                            .requestMatchers(HttpMethod.OPTIONS).permitAll()
                            // .requestMatchers("/equipments").permitAll()
                            // identical functionality apparently
                            // .requestMatchers("equipments").permitAll()

                            .requestMatchers("signIn").permitAll().requestMatchers("register").permitAll()
                            .requestMatchers("swagger-ui/index.html").permitAll().requestMatchers("swagger-ui/**").permitAll().requestMatchers("v3/api-docs/swagger-config")
                            .permitAll().requestMatchers("v3/api-docs/**").permitAll()
                            .requestMatchers("vscode-webview://0td9burpspgsefg53fh007rkvhdabkdm10ujsci3rj2hddorron8")
                            .permitAll()
                            // .anyRequest().permitAll();
                            .anyRequest().authenticated();
                }).sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

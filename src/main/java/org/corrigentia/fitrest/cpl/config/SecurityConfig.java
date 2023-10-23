package org.corrigentia.fitrest.cpl.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.corrigentia.fitrest.cpl.config.jwt.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    /*
     * @Bean public AuthenticationManager
     * authenticationManager(AuthenticationManagerBuilder auth) throws Exception{
     * return auth .build(); }
     */

    @Bean
    public AuthenticationManager authenticationManager(final AuthenticationConfiguration configuration)
            throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public CsrfCookieFilter CsrfCookieFilter() {
        return new CsrfCookieFilter();
    }

    @Bean
    public SecurityFilterChain httpSecurity(final HttpSecurity http, final JwtFilter jwtFilter) throws Exception {

        final CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        // set the name of the attribute on which the CsrfToken will be
        // populated
        requestHandler.setCsrfRequestAttributeName(null);

        CsrfCookieFilter csrfCookieFilter = CsrfCookieFilter();

        // maybe need this to upload from angular to spring
//        http.cors(); // deprecated
        http.cors(Customizer.withDefaults());

        http
                .addFilterAfter(csrfCookieFilter, CsrfFilter.class)
                // .cors(CorsConfigurer::disable)
                // .cors(AbstractHttpConfigurer::disable)

                .csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            // this is a must for Angular v14+ because it sends preflight with http method
                            // options and spring security blocks it by default
                            .requestMatchers(HttpMethod.OPTIONS).permitAll()

                            // .requestMatchers("/equipments").permitAll()
                            // identical functionality apparently
                            // .requestMatchers("equipments").permitAll()

                            .requestMatchers("api/students/new").permitAll()
                            .requestMatchers("api/instructors/new").permitAll()
                            .requestMatchers("api/admins/new").permitAll()

                            .requestMatchers("signIn").permitAll()
                            .requestMatchers("/api/signIn").permitAll()

                            .requestMatchers("register").permitAll()
                            .requestMatchers("/api/register").permitAll()

                            .requestMatchers("swagger-ui/index.html").permitAll().requestMatchers("swagger-ui/**")
                            .permitAll().requestMatchers("v3/api-docs/swagger-config").permitAll()
                            .requestMatchers("v3/api-docs/**").permitAll()
                            .requestMatchers("vscode-webview://0td9burpspgsefg53fh007rkvhdabkdm10ujsci3rj2hddorron8")
                            .permitAll()

                            // need this to upload from angular to spring
                            .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()

                            // .anyRequest().permitAll();
                            .anyRequest().authenticated();
                    // ;
                }).csrf(csrf -> {
                    // add here all the paths where you want to be able to create a new entry in the database for instance
                    // api/equipments enough for GET ALL/ID & POST; but INSUFFICIENT
                    // for PUT
                    // api/equipments/** NECESSARY for PUT
                    csrf.ignoringRequestMatchers("signIn", "api/signIn", "register", "api/register",
                                    "api/students/16/photo", "api/upload", "api" +
                                            "/equipments/**", "api" +
                                            "/martialArts/**", "api" +
                                            "/instructors/**", "api/students/*" +
                                            "*", "api/classes/**", "api/martial" +
                                            "-art-classes/**")
                            .csrfTokenRequestHandler(requestHandler);
                })

                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /******************************************/

    private static final class CsrfCookieFilter extends OncePerRequestFilter {
        private static final String REQUEST_ATTRIBUTE_NAME = "_csrf";
        private static final String RESPONSE_HEADER_NAME = "X-CSRF-HEADER";
        private static final String RESPONSE_PARAM_NAME = "X-CSRF-PARAM";
        private static final String RESPONSE_TOKEN_NAME = "X-CSRF-TOKEN";

        @Override
        protected void doFilterInternal(HttpServletRequest request,
                                        HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            // CsrfToken csrfToken = (CsrfToken)
            // request.getAttribute(CsrfToken.class.getName());
            CsrfToken csrfToken = (CsrfToken) request.getAttribute(REQUEST_ATTRIBUTE_NAME);

            if (csrfToken != null) {
                response.setHeader(RESPONSE_HEADER_NAME, csrfToken.getHeaderName());
                response.setHeader(RESPONSE_PARAM_NAME, csrfToken.getParameterName());
                response.setHeader(RESPONSE_TOKEN_NAME, csrfToken.getToken());
            }

            response.setHeader("withCredentials", "true");
            response.setHeader("Access-Control-Allow-Headers", "withCredentials");

            // csrfToken.getToken(); //
            filterChain.doFilter(request, response);
        }
    }

    /*
     * @Bean(name="multipartResolver")
     * public CommonsMultipartResolver multipartResolver() {
     *
     * }
     */
}

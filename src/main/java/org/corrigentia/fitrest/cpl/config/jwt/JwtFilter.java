package org.corrigentia.fitrest.cpl.config.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.corrigentia.fitrest.cpl.utils.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final UserDetailsService userDetailsService;
    private final JwtUtil util;

    public JwtFilter(UserDetailsService userDetailsService, JwtUtil util) {
        this.userDetailsService = userDetailsService;
        this.util = util;
    }

    /**
     * Same contract as for {@code doFilter}, but guaranteed to be just invoked once
     * per request within a single request thread. See
     * {@link #shouldNotFilterAsyncDispatch()} for details.
     * <p>
     * Provides HttpServletRequest and HttpServletResponse arguments instead of the
     * default ServletRequest and ServletResponse ones.
     *
     * @param request
     * @param response
     * @param filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        System.out.println();
        System.out.println(
                "doFilterInternal(HttpServletRequest request,                                    HttpServletResponse response,                                     FilterChain filterChain     )");
        System.out.println();

        System.out.println();
        System.out.println("request: " + request);
        System.out.println();

// "Bearer asdfsaerxcvrtsdsdaf"
        String authorization = request.getHeader("Authorization");

        System.out.println();
        System.out.println("authorization: " + authorization);
        System.out.println();

        if (null != authorization) {
            String[] authorizations = authorization.split(" ");
            String type = authorizations[0];
            String token = authorizations[1];

            if (!token.isEmpty() && !"null".equalsIgnoreCase(token) && "Bearer".equals(type)) {

                System.out.println();
//                System.out.println("token: " + token);
                System.out.println();

                // TODO: 06-10-23 : I might need to change this to getEmail 
                String username = util.getUsernameFromToken(token);
                UserDetails user = userDetailsService.loadUserByUsername(username);

                if (util.validateToken(token, user)) {
                    UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(user, null,
                            user.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(upat);
                }
            }
        }

        System.out.println();
        System.out.println("request: " + request);
        System.out.println();

        System.out.println();
        System.out.println("response: " + response);
        System.out.println();

        filterChain.doFilter(request, response);
    }
}

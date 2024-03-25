package nl.loahy_v3.config;

import nl.loahy_v3.filters.JwtRequestFilter;
import nl.loahy_v3.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;

    private final JwtRequestFilter jwtRequestFilter;

    @Autowired
    public SpringSecurityConfig(JwtRequestFilter jwtRequestFilter, CustomUserDetailsService customUserDetailsService) {
        this.jwtRequestFilter = jwtRequestFilter;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailsService);

    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                .antMatchers(HttpMethod.GET, "/user/admin@test.nl").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/user/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/user/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST, "/remark").permitAll()
                .antMatchers(HttpMethod.GET, "/remark/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/remark/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "image/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "image/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/image/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/product").permitAll()
                .antMatchers(HttpMethod.GET, "/product/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/product/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/product/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/product/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/product/{id}/image").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST, "/order/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/order/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/order").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST, "/address/").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/address/{id}").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/address/{id}").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/address/zipcode").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/address/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/address/post").hasRole("USER")

                .antMatchers(HttpMethod.GET, "/wishlist/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/wishlist/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/{wishlistId}/{productId}").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/{wishlistId}/{productId}").hasRole("USER")

                .antMatchers("/authenticated").authenticated()
                .antMatchers("/authenticate").permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
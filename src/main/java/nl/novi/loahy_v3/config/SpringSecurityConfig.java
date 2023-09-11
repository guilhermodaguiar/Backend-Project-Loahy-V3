package nl.novi.loahy_v3.config;

import nl.novi.loahy_v3.filters.JwtRequestFilter;
import nl.novi.loahy_v3.services.CustomUserDetailsService;
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

    @Autowired
    public CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
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

        //JWT token authentication
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.GET, "/users/{id}").hasRole("USER")
                .antMatchers(HttpMethod.PATCH, "/users/{id}").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/users/delete/{id}").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST, "/contact-remarks").permitAll()
                .antMatchers(HttpMethod.GET, "/contact-remarks").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/contact-remarks/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "images/download/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "images/upload").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "images/delete").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/products").permitAll()
                .antMatchers(HttpMethod.GET, "/products/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/products/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/products/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/products/{id}/image").hasRole("ADMIN")


                .antMatchers(HttpMethod.POST, "/orders").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/orders/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/orders").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST, "/address").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "address/{id}").hasRole("USER")
                .antMatchers(HttpMethod.GET, "address/{id}").hasRole("USER")
                .antMatchers(HttpMethod.GET, "address").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST, "/products/image-upload").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/products/image-delete").hasRole("ADMIN")


                .antMatchers("/authenticate").permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
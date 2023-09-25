package bank.xyz.bankapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AntPathRequestMatcher antPathRequestMatcherH2 = new AntPathRequestMatcher("/h2-ui/**");
        AntPathRequestMatcher antPathRequestMatcherReg = new AntPathRequestMatcher("/register/**");
        http.authorizeHttpRequests((authz) -> authz
                        .requestMatchers(antPathRequestMatcherH2).permitAll()
                        .requestMatchers(antPathRequestMatcherReg).permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

}
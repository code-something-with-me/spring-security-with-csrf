package code.with.me;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author andong@xiaomalixing.com
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ProjectConfig {
//    @Bean
//    public UserDetailsService userDetailsService() {
//        var manager = new InMemoryUserDetailsManager();
//
//        var user1 = User.withUsername("frank")
//                .password("12345")
//                .roles("ADMIN")
//                .build();
//
//        manager.createUser(user1);
//        return manager;
//    }
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//

    private final MyCsrfTokenRepository myCsrfTokenRepository;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.anyRequest().permitAll()
                )
                .csrf(csrf -> {
                    csrf.csrfTokenRepository(myCsrfTokenRepository);
                })
                .httpBasic(withDefaults())
                .build();
    }

}

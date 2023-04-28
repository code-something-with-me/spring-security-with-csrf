package code.with.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class SpringSecurityWithCsrfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithCsrfApplication.class, args);
	}

}

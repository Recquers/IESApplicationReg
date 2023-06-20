
package in.vasanth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import in.vasanth.service.CustomUserDetailService;

@Configuration

@EnableWebSecurity

public class SecurityConfig extends AsyncConfigurerSupport {

	@Autowired
	private CustomUserDetailService customUser;

	@Autowired
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(customUser).passwordEncoder(NoOpPasswordEncoder.getInstance());

	}
   
	
	
	
	@Bean
	public SecurityFilterChain security(HttpSecurity http) throws Exception {
            
		http.authorizeHttpRequests(request-> request.antMatchers("/").permitAll().antMatchers("/register").hasRole("USER")

				.anyRequest().authenticated()).httpBasic();

		return http.csrf().disable().build();
	}
	
	
}

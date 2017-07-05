package theFallen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired private FallenUserRepository repository;
	
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return new FallenUserDetailsService(repository);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests().anyRequest().authenticated();
				//.antMatchers("/homepage").hasRole("USER");
		
		http
				.antMatcher("/signuppage")
				.formLogin().failureUrl("/")
				.defaultSuccessUrl("/homepage")
				.loginPage("/login")
				.permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsServiceBean());
		
	}
}

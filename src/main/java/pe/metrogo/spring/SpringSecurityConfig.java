package pe.metrogo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.metrogo.spring.auth.handler.LoginSuccessHandler;
import pe.metrogo.spring.serviceimpl.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private LoginSuccessHandler succesHandler;

	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.authorizeRequests()
				.antMatchers("/nacionalidad/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/promocion/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/ttarjetametro/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/ttarjeta/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/entidad/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/tarjeta/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
				.antMatchers("/tmetro/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
				.antMatchers("/recarga/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')").and()
				.formLogin().successHandler(succesHandler).loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/nacionalidad/bienvenido")
				.permitAll().and().logout().logoutSuccessUrl("/login").permitAll().and().exceptionHandling().accessDeniedPage("/error_403");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
}

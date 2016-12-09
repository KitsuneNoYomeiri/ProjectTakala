package project.lol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import project.lol.web.UserDetailService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)  //Used to secure methods with Java configuration
@EnableWebSecurity	//Enables Spring Security web security support


public class ProjectSecurity extends WebSecurityConfigurerAdapter {
	@Autowired	// provides control over where and how autowiring should be accomplished
	private UserDetailService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers("(css/**").permitAll() // Enables css for all users
		.and()
		.authorizeRequests().antMatchers("/signup", "/saveuser").permitAll() //Allows user creation without logging in
		.and()
		.authorizeRequests().anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/matchlist") //where you go after succesful login
			.permitAll()
			.and()
		.logout()
			.permitAll();
	}
	
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	       auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder()); // to encode the hash password
	 }
	
}

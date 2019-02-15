package com.amljdhv.web.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*@Autowired
    private AccountService accountService;*/

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;


	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;

	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	/*@Bean
	public TokenBasedRememberMeServices rememberMeServices() {
		return new TokenBasedRememberMeServices("remember-me-key", accountService);
	}*/

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.
		jdbcAuthentication()
		.usersByUsernameQuery(usersQuery)
		.authoritiesByUsernameQuery(rolesQuery)
		.dataSource(dataSource)
		.passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// temporary use only
		//http.csrf().disable().authorizeRequests().anyRequest().permitAll(); 

		http.
		authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/signin", "/signUp", "/verify", "/createConsumer" , "/images/**").permitAll()
		.antMatchers("/registration","/resources/**","/static/**","/webjars/**", "/static/angularJS/**","/angularJS/**", "/static/js/**", "/static/css/**", "/vendor/**", "/aboutUs", "/contactUs", "/signup").permitAll()
		.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
		.antMatchers("/user/**").hasAnyRole("ROLE_USER")
		.anyRequest()
		.authenticated().and().csrf().disable().formLogin()
		.loginPage("/signin").failureUrl("/signin?error=true") //login
		.successHandler(myAuthenticationSuccessHandler())
		
//		.defaultSuccessUrl("/")
		.usernameParameter("email")
		.passwordParameter("password")
		.and().logout()
		.logoutSuccessHandler(logoutSuccessHandler())
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/signin?logout").and().exceptionHandling()
		.accessDeniedPage("/access-denied");
		

	}
	
	@Bean
	public LogoutSuccessHandler logoutSuccessHandler(){
		return new MyLogoutSuccessHandler();
	}
	
	@Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

	@Bean(name = "authenticationManager")
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}



	@Override
	public void configure(WebSecurity web) throws Exception {
		web
		.ignoring()
		.antMatchers("/resources/**", "/static/**", "/js/**", "/css/**", "/img/**", "/json/**");
	}


	/*	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
    }*/
}

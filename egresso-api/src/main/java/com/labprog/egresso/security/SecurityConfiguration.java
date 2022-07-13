package com.labprog.egresso.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.labprog.egresso.service.EgressoService;


@Configurable
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Autowired
  private EgressoService service;
  @Autowired
  private PasswordEncoder passwordEncoder;

    
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable()
      .authorizeRequests()
      .antMatchers(HttpMethod.POST,SecurityConstants.SIGN_UP_STRING).permitAll() 
      //URL pública
      .antMatchers(HttpMethod.POST, "/login").permitAll()
      .anyRequest().authenticated()
      .and()                
      //quem vai autenticar e como
      .addFilter(new AuthenticationFilter(authenticationManager()))
      //quem vai autorizar e como
      .addFilter(new AuthorizationFilter(authenticationManager()))                
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) 
    throws Exception {        
    // configura o método de autenticação
    auth.userDetailsService(service)
      .passwordEncoder(passwordEncoder);    
  }
    

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    final UrlBasedCorsConfigurationSource source = 
      new UrlBasedCorsConfigurationSource();
    source
      .registerCorsConfiguration("/**", new CorsConfiguration()
      .applyPermitDefaultValues());
    return source;
  }
}

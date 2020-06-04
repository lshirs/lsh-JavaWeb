package com.lsh.config;

import com.lsh.service.impl.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    SessionRegistry sessionRegistry;

    @Bean
    public SessionRegistry getSessionRegistry(){
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }

    @Bean
    UserDetailsService customUserService() { return new CustomUserService();}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 放行外部资源
        http.headers().frameOptions().disable();
        // 跨域问题
        http.csrf().disable();


        http
                .authorizeRequests()    //验证请求
                .antMatchers("/assets/**","/js/**","/public/**","/front/**").permitAll() //放行部分合法路径
                .antMatchers("/f/**").permitAll() //放行部分合法路径
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/a/user/login")
                .defaultSuccessUrl("/a/index",true) //登录成功的默认跳转路径
                .failureUrl("/a/user/login?error") //登录失败的跳转路径
                .permitAll() //登录页面用户任意访问
                .and()
                .logout().permitAll().invalidateHttpSession(true)
                .and().sessionManagement().maximumSessions(10).expiredUrl("/a/user/login"); //注销行为任意访问

    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder());
    }
}

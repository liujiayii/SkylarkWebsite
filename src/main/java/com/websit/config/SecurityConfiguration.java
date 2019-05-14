package com.websit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.websit.service.impl.MyAccessDeniedHandler;
import com.websit.service.impl.MyAuthenctiationFailureHandler;
import com.websit.service.impl.MyAuthenctiationSuccessHandler;
import com.websit.service.impl.MyExpiredSessionStrategy;
import com.websit.service.impl.MyFilterSecurityInterceptor;
import com.websit.service.impl.T_adminServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
	
	@Autowired
	private MyAuthenctiationSuccessHandler myAuthenctiationSuccessHandler;
	
	@Autowired
	private MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;
	
	@Autowired
	private MyAccessDeniedHandler myAccessDeniedHandler;
	
	/** 阻止控制台打印 Using default security password: */
	@Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	/** session失效处理 */
	@Bean
	public MyExpiredSessionStrategy myExpiredSessionStrategy() {
		return new MyExpiredSessionStrategy();
	}
	
	/** 获取数据库中信息存到User对象中 */
	@Bean
    public UserDetailsService userService(){
        return new T_adminServiceImpl();
    }
	
	/**加密密码*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/** 授权*/
    @Override
	protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable();
    	http.authorizeRequests()
    		.antMatchers("/**").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .exceptionHandling().accessDeniedHandler(myAccessDeniedHandler)
	        .and()
	        .formLogin()
	        .loginPage("/backer/")
	        .loginProcessingUrl("/login")
	        .successHandler(myAuthenctiationSuccessHandler)
		    .failureHandler(myAuthenctiationFailureHandler)
	        .permitAll() //登录页面用户任意访问
	        .and()
	        .logout()
	        .logoutUrl("/logout")  //执行注销的url
	    	.invalidateHttpSession(true) // 指定是否在注销时让httpSession无效
	    	.deleteCookies("JESSIONID")  // 清除cookie
	    	//.logoutSuccessUrl("/backer/") // 注销成功后跳转的url; 
    		.permitAll();
    	
    	http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    	//单用户登录，如果有一个登录了，同一个用户在其他地方登录将前一个剔除下线
        http.sessionManagement().maximumSessions(100).expiredSessionStrategy(myExpiredSessionStrategy());
         
 		//单用户登录，如果有一个登录了，同一个用户在其他地方不能登录
 	    //http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);
 	    // session失效跳转页面
 	    http.sessionManagement().invalidSessionUrl("/invalidSessionStrategy");
	}

	/** 认证 */	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService()).passwordEncoder(passwordEncoder());
	}

	/** 放行静态资源 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/assets/**");
        web.ignoring().antMatchers("/views/**");
	}

	
}

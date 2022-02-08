package h5EDULive.config;

import h5EDULive.service.impl.AuthUserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;

@Configuration//java形式的bean spring3.0以后 允许以 @Configuration 注解来代替XML形式的bean
@EnableWebSecurity//用这个注解开启 spring security配置验证开启
public class SecurityConfig extends WebSecurityConfigurerAdapter {//继承WebSecurityConfigurerAdapter适配器且重写configure 函数 来实现访问的控制（那些访问/资源 需要哪些权限）和登录的验证（数据库验证/内存验证）
    private AuthUserService authUserService;

    public SecurityConfig(AuthUserService authUserService) {
        this.authUserService = authUserService;
    }

    @Resource
    private MyAuthenticationProvider myAuthenticationProvider;//自定义验证

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authUserService);
        auth.authenticationProvider(myAuthenticationProvider);
        //inMemoryAuthentication 从内存中获取
        //auth.
        //inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user1").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
    }

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    /*@Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(authUserService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }*/

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()//通过authorizeRequests()配下的子函来完成访问/授权 配置
                .antMatchers("/meta/**", "/res/**", "/stat/**", "/oth/**", "/", "/index", "/register", "/courseList", "/course").permitAll()//antMatchers里配置的资源是可以被所有用户访问（permitAll）的
                .anyRequest().authenticated()
                .and()//类似于结束标签
                .formLogin()//通过formLogin()配下的函数对登录form进行配置
                .loginPage("/login")//设置登录页面
                .defaultSuccessUrl("/index")//默认登录成功跳转地址
                .failureUrl("/loginError")//默认登录失败跳转地址
                .usernameParameter("txtUserCd")
                .passwordParameter("txtUserPwd")//用户名密码验证用*这里的参数要和画面上控件名保持一致
                .permitAll()

                .and()
                .logout()//通过logout()配下的函数对注销进行配置
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//设置注销用的请求URL
                .logoutSuccessUrl("/")//设置注销成功后的跳转URL
                .deleteCookies("JSESSIONID")//消除Cookie
                .invalidateHttpSession(true)//销毁Session
                .permitAll();
//                .and()
//                .sessionManagement()//通过sessionManagement配下的函数对session配置
//                .invalidSessionUrl("/session_expired")
//                .maximumSessions(1)//同一用户session上限设定 *比如同一个用户多次登录
//                .maxSessionsPreventsLogin(true)//maximumSessions设定的上限启用 * 超出报错
//                .expiredUrl("/session_expired");//超过session上限跳转URL设定
        //回头tpSecurity.logout().permitAll();

    }

}

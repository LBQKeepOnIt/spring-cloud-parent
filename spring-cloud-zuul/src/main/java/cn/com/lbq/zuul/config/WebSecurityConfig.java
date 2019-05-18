package cn.com.lbq.zuul.config;

import cn.com.lbq.ucenter.api.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/5/18 15:03
 */
@Configuration
//@EnableWebSecurity // 创建了一个WebSecurityConfigurerAdapter，且自带了硬编码的order=3,使用spring security而不是auth
@Order(1) // 定义拦截器配置拦截次序,高于ResourceServerConfigurerAdapter
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

// 自定义用户服务-校验用户是否合法，实现改接口，spring即可获取对应用户的角色、权限等信息，然后可以拦截URL判断是否具有对应权限

    // 具体是否可以访问对应URL配置可以在HttpSecurity中配置

    @Resource
    private UserClient userClient;


    /**
     * 密码加密器:将用户密码进行加密
     *
     * @return
     */

    @Bean
    public PasswordEncoder passwordEncoder() {

// 使用BCrypt进行密码的hash

        return new BCryptPasswordEncoder();

    }

    /**
     * 不定义没有password grant_type即密码授权模式（总共四种授权模式：授权码、implicat精简模式、密码、client credentials）
     */

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();

    }


    /**
     * 系统安全用户验证模式：
     * 1、使用内存模式创建验证
     * 2、使用数据库创建验证，实现userDetailsService接口即可
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


    // 将验证过程交给自定义

    //        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());


    // 内存创建用户：写死不利于项目实际应用

    // 验证的时候就是通过创建的用户名、密码、角色进行验证的

    // 创建一个用户名是“user”，密码是“password”，角色是“ROLE_USER”的用户

    // 创建一个用户名是“admin”，密码是“123456”，角色是“ROLE_ADMIN以及ROLE_USER”的用户

    //auth.inMemoryAuthentication().withUser("user").password("password").roles("USER") // 在内存中的验证(memory authentication)叫作”user”的用户

    //.and().withUser("admin").password("123456").roles("ADMIN", "USER") ;  // 在内存中的验证(memory authentication)叫作”admin”的管理员用户

    }

    /**
     * 如果有要忽略拦截校验的静态资源，在此处添加
     * 忽略任何以”/resources/”开头的请求，这和在XML配置http@security=none的效果一样
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    /**
     * 允许对特定的http请求基于安全考虑进行配置,默认情况下，适用于所有的请求，
     * 但可以使用requestMatcher(RequestMatcher)或者其它相似的方法进行限制
     */

    @Override

    protected void configure(HttpSecurity http) throws Exception {

    // 如：将所有的url访问权限设定为角色名称为"ROLE_USER"

    // http.authorizeRequests().antMatchers("/").hasRole("USER").and().formLogin();


    // 启用HTTP Basic和基于表单的验证

    //        http.authorizeRequests()// 定义权限配置
    //
    //                .anyRequest().authenticated()// 任何请求都必须经过认证才能访问
    //
    //                .and()
    //
    //                .formLogin()
    //
    //                .permitAll()// 允许任何人访问登录url
    //
    //                .and()
    //
    //                .csrf().disable()// 禁止跨域请求
    //
    //                .httpBasic();// 进行http Basic认证


    // 无需访问权限

        http.authorizeRequests()

                .antMatchers("/**/test.*", "/**/*.css", "/**/*.js", "/**/images/*").permitAll()

                // admin角色访问权限 ADMIN

                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")//“/admin/”开头的URL必须要是管理员用户，譬如”admin”用户

                // user角色访问权限

                .antMatchers("/**/operator/*.*").hasAuthority("ROLE_USER")

                // 公共页面

                .antMatchers("/signup", "/about").permitAll()// 任何人(包括没有经过验证的)都可以访问”/signup”和”/about”

                // 其他请求授权

                .anyRequest().authenticated()// 其余所有请求全部需要鉴权认证

                .and()

                // login页面自定义配置都可以访问

                .formLogin()// 使用Java配置默认值设置了基于表单的验证。使用POST提交到”/login”时，需要用”username”和”password”进行验证

                .loginPage("/login")// 注明了登陆页面，意味着用GET访问”/login”时，显示登陆页面

                .permitAll()// 任何人(包括没有经过验证的)都可以访问”/login”和”/login?error”

                .and()

                .logout().permitAll();// 任何人都可以登出页面都可以访问

    }

}


//更全配置实例：

// 无需访问权限

//        http.authorizeRequests()
//
//        .antMatchers("/**/test.*", "/**/*.css","/**/*.js","/**/images/*").permitAll()
//
//        // admin角色访问权限 ADMIN
//
//        .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")//“/admin/”开头的URL必须要是管理员用户，譬如”admin”用户
//
//        // user角色访问权限
//
//        .antMatchers("/**/operator/*.*").hasAuthority("ROLE_USER")
//
//        // 公共页面
//
//        .antMatchers("/signup","/about").permitAll()// 任何人(包括没有经过验证的)都可以访问”/signup”和”/about”
//
//        // 其他请求授权
//
//        .anyRequest().authenticated()// 其余所有请求全部需要鉴权认证
//
//        .and()
//
//        // login页面自定义配置都可以访问
//
//        .formLogin()// 使用Java配置默认值设置了基于表单的验证。使用POST提交到”/login”时，需要用”username”和”password”进行验证
//
//        .loginPage("/login")// 注明了登陆页面，意味着用GET访问”/login”时，显示登陆页面
//
//        .permitAll()// 任何人(包括没有经过验证的)都可以访问”/login”和”/login?error”
//
//        .and()
//
//        .logout().permitAll();// 任何人都可以登出页面都可以访问


package cn.com.lbq.zuul.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override

    public void configure(HttpSecurity http) throws Exception {

        http
                // 关闭跨域请求
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .authorizeRequests()// 定义权限配置
                // 允许/test和/oauth/token请求路径
                .antMatchers("/test", "/oauth/token").permitAll()// 这两个页面任何人都可以访问
                .anyRequest().authenticated()// 其他任何请求都需要验证
                .and()
                .formLogin()
                .permitAll()// 允许任何人访问登录url
                .and()
                .httpBasic();
    }
}
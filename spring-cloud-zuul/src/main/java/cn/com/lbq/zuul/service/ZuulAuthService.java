package cn.com.lbq.zuul.service;

import cn.com.lbq.zuul.filter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/5/17 10:19
 */
@Component
public class ZuulAuthService {


    @Bean
    public FirstPreFilter firstPreFilter(){
        return new FirstPreFilter();
    }

    @Bean
    public SecondPreFilter secondPreFilter() {
        return new SecondPreFilter();
    }

    @Bean
    public ThirdPreFilter thirdPreFilter() {
        return new ThirdPreFilter();
    }

    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

}

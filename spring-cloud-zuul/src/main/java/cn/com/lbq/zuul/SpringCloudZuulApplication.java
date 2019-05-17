package cn.com.lbq.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/28 16:45
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableCircuitBreaker
public class SpringCloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulApplication.class, args);
    }

    /**
     * Groovy加载方法配置，20秒自动刷新
     */
//    @Component
//    public static class GroovyRunner implements CommandLineRunner {
//        @Override
//        public void run(String... args) throws Exception {
//            MonitoringHelper.initMocks();
//            FilterLoader.getInstance().setCompiler(new GroovyCompiler());
//            try {
//                FilterFileManager.setFilenameFilter(new GroovyFileFilter());
//                FilterFileManager.init(20, "/Users/Administrator/workspace-scbook/ch8-1/ch8-1-zuul-server/src/main/java/cn/springcloud/book/groovy");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
}



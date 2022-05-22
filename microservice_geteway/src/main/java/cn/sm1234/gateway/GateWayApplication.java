package cn.sm1234.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 網關微服務
 */
@SpringBootApplication
@EnableZuulProxy // 開啟網關代理功能
@EnableSwagger2 // 開啟Swagger功能
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }
}

package demo.springboot.dubbo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(ApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("demo.springboot.dubbo.consumer.controller"))//该包下的类将会自动生成文档
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo ApiInfo() {
        return new ApiInfoBuilder()
        		.contact(new Contact("carson", "https://github.com/carson1986/demo-springboot-dubbo.git", "364930352@qq.com"))
                .title("消费端接口")
                .version("1.0")
                .build();
    }
}
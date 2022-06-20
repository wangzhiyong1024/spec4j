package wang.zhiyong.spec4j.web.configuration;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author WangZhiyong
 * @date 2022/6/16 22:41
 */
@Configuration
public class  SwaggerConfiguration {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.OAS_30)
        .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        .build();
  }
}

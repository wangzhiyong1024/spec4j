package wang.zhiyong.spec4j.web.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis 框架配置类
 *
 * @author WangZhiyong
 * @date 2022/6/16 22:38
 */
@MapperScan("wang.zhiyong.spec4j.dao")
@Configuration
public class MybatisConfiguration {

}

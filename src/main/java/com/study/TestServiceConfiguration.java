package com.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 如果一个配置类只配置@ConfigurationProperties注解，而没有使用@Component，
 * 那么在IOC容器中是获取不到properties 配置文件转化的bean。
 * 说白了 @EnableConfigurationProperties 相当于把
 * 使用 @ConfigurationProperties 的类进行了一次注入。
 *
 * @ConditionalOnBean：当容器里有指定的Bean为true
 * @ConditionalOnClass：当类路径下有指定的类为true
 * @ConditionalOnMissingBean：当容器里没有指定的Bean为true
 * @ConditionalOnProperty：指定的数据是否有指定的值
 *
 */
@Configuration
@EnableConfigurationProperties(TestProperties.class)
@ConditionalOnClass(TestService.class)
public class TestServiceConfiguration {

    @Autowired
    private TestProperties testProperties;

    @Bean
    @ConditionalOnMissingBean(TestService.class)
    public TestService testService(){
        TestService testService = new TestService();
        testService.setMsg(testProperties.getMsg());
        return testService;
    }
}

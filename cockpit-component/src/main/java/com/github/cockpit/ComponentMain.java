package com.github.cockpit;

import com.github.cockpit.component.UsrFrComponent;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * ComponentMain
 * Create on 2017/3/10
 *
 * @author Asin Liu
 * @version 1.0
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@MapperScan("com.github.cockpit.mapper")
public class ComponentMain {

    @Resource
    UsrFrComponent component;

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(ComponentMain.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.setWebEnvironment(false);
        app.run(args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return (String... args) -> {
            System.out.println("Component is ready to run...");
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

            System.out.println("Enjoy ur work!");
        };
    }

    /**
     * Test the which transaction manager is used.
     * @param platformTransactionManager
     * @return
     */
    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println(">>>>>>>>>> " + platformTransactionManager.getClass().getName());
        return new Object();
    }
}

package com.github.cockpit;

import com.github.cockpit.mapper.FrMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.annotation.Resource;

/**
 * MapperMain
 * Create on 2017/3/14
 *
 * @author Asin Liu
 * @version 1.0
 */
@ComponentScan
@Configuration
@EnableAutoConfiguration
@MapperScan("com.github.cockpit.mapper")
public class MapperMain {
    public static void main(String[] args) {
        SpringApplication.run(MapperMain.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(){
        return (String... args) ->{
            System.out.println("Mapper is ready to run...");
            System.out.println("Enjoy ur work!");

        };
    }
}

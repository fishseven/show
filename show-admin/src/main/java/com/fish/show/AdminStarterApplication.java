package com.fish.show;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 启动程序
 * @author
 */

@SpringBootApplication(scanBasePackages = "com.fish.*")
@ServletComponentScan
@EnableAsync
@MapperScan(basePackages = "com.fish.show.mappers")
public class AdminStarterApplication extends SpringBootServletInitializer
{
    public static void main(String[] args)
    { SpringApplication.run(AdminStarterApplication.class, args); }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(AdminStarterApplication.class);
    }
}
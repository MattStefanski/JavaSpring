package com.crud.tasks;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class TasksApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(TasksApplication.class, args);
    }

    //Commented for Heroku Deployment
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applcation) {
        return applcation.sources(TasksApplication.class);
    }

}

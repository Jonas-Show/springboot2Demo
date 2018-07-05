package com.udian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@MapperScan("com.udian.**.mapper")
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication app = new SpringApplication(App.class);
        app.setWebApplicationType(WebApplicationType.REACTIVE);
        app.run();
    }
}

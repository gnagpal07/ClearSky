package io.egen.api;

import io.egen.api.config.SwaggerConfig;
import io.egen.api.config.WebConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
@Import({WebConfig.class, SwaggerConfig.class})
public class App 
{
    public static void main( String[] args )
    {
    	//System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
        SpringApplication.run(App.class, args);
    }
}

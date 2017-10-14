package fr.mpush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MessagePushMainLauncherApp {

    public static void main(String... args) throws Exception {
        SpringApplication.run(MessagePushMainLauncherApp.class, args);
    }
}

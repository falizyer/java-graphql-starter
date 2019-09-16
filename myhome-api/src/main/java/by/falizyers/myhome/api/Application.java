package by.falizyers.myhome.api;

import by.falizyers.myhome.core.EnableCoreConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "by.falizyers.myhome.core",
        "by.falizyers.myhome.api"
})
@EnableCoreConfig
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

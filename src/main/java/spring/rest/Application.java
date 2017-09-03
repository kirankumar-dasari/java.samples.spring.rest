package spring.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String get() {
        return "Welcome to java samples and spring-rest application.";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}

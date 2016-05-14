package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        final String url = "http://188.247.227.127:8080/message";
//
//        restTemplate.getForObject(url, Message.class);
//        restTemplate.postForObject(url, new JSONMessage("main", new Date(), "1", "2", "alin", "asd"),  JSONMessage.class);

//        System.out.println(greeting);
    }
}

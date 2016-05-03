package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        final String url = "http://188.247.227.127:8080/message";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        restTemplate.getForObject(url, Message.class);
        restTemplate.postForObject(url, new JSONMessage("main", new Date(), "1", "2", "alin", "asd"),  JSONMessage.class);

//        System.out.println(greeting);
    }
}

/*
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        IPersonDao pdao = ctx.getBean(IPersonDao.class);
        pdao.savePerson();
        System.out.println("Done");
    }
}
*/
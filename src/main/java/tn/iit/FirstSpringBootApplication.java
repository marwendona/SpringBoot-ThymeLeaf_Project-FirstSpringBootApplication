package tn.iit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.iit.beans.HelloBean;

@SpringBootApplication
public class FirstSpringBootApplication implements CommandLineRunner {

    @Autowired
    private HelloBean bean;

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Hello Spring");
        System.out.println(bean.getMessage(" From ENIS Engineer"));
    }
}

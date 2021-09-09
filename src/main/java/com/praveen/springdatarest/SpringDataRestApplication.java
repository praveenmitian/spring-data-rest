package com.praveen.springdatarest;

import com.praveen.springdatarest.entity.ApplicationUser;
import com.praveen.springdatarest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataRestApplication {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init(){
        userRepository.saveAll(Stream.of(new ApplicationUser(1, "Praveen", "praveen@gmail.com"),
                new ApplicationUser(2, "Ram", "ram@gmail.com"),
                new ApplicationUser(3, "Dileep", "dileep@gmail.com"),
                        new ApplicationUser(4, "Anil", "anil@gmail.com"))
                .collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestApplication.class, args);
    }

}

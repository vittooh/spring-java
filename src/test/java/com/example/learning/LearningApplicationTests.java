package com.example.learning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class LearningApplicationTests {

    @Test
    void contextLoads() {

        BCryptPasswordEncoder b = new BCryptPasswordEncoder();


        System.out.println(b.encode("teste123"));
    }

}

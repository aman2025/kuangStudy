package com.ks;

import com.ks.pojo.Dog;
import com.ks.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigApplicationTests {
//    @Autowired
//    Person person;

    @Autowired
    Dog dog;



    @Test
    public void contextLoads() {
        System.out.println(dog.getName());

    }

}

package com.fish.show;

import com.fish.show.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationsApplicationTests {

    @Autowired
    private TestService testService;
    //    @Test
//    @Myannotation("nihao")
//    public void contextLoads() {
//        System.out.println("吃饭");
//    }
    @Test
    //@Myannotation("nihao")
    public void test1() {
for(int i=0;i<100;i++) {
    testService.calculate(10, 11, 100);
}


    }
}

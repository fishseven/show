package com.fish.show.service;

import com.fish.show.domain.User;
import com.fish.show.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TestService {
    @Autowired
    private UserMapper userMapper;


    public List<User> getDetail(){
        return userMapper.getDetail();
    }

    private static int COUNT = 0;

    public void calculate(double inAmount,double outAmount,double totalAmount){
        COUNT++;
//        double dayGet = 0;
//        System.out.println("============");
//        System.out.println("start");
//        System.out.println("inAmount:"+inAmount+"--"+"outAmountz:"+outAmount+"--"+"totalAmount:"+totalAmount);
//
//        System.out.println("============"+totalAmount/inAmount);
        totalAmount += totalAmount/inAmount*(outAmount-inAmount);
        Random random = new Random();
        int i = random.nextInt(99);
        if(i>=0&&i<48) {
            inAmount++;
            //System.out.println("true");
        }else {
            outAmount++;
            //System.out.println("false");
        }

//        System.out.println("end");
//        System.out.println("inAmount:"+inAmount+"--"+"outAmountz:"+outAmount+"--"+"totalAmount:"+totalAmount);
//        System.out.println("============");
        if(totalAmount>1000){
            System.out.println("~~~~~~~~~~~COUNT:~~~~~~~~~~~"+COUNT);
            return;
        }
        calculate(inAmount,outAmount,totalAmount);

    }

    public void calculate2(double inAmount,double outAmount,double totalAmount){
        COUNT++;
        totalAmount += totalAmount/inAmount*(outAmount-inAmount);
        Random random = new Random();
        int i = random.nextInt(99);
        if(i>=0&&i<48) {
            inAmount++;
        }else {
            outAmount++;
        }
        if(totalAmount>1000){
            System.out.println("~~~~~~~~~~~COUNT:~~~~~~~~~~~"+COUNT);
            return;
        }
        calculate2(inAmount,outAmount,totalAmount);

    }

}

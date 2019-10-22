package com.bdqn.hx.service;


import com.bdqn.hx.pojo.Informations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InformationsServiceTest {

    @Resource
    InformationsService informationsService;

    @Test
    public void test1(){
        List<Informations> list = informationsService.queryAll();
        System.out.println("list = " + list);
    }

}
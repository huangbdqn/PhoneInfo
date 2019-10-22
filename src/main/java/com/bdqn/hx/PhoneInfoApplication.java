package com.bdqn.hx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.bdqn.hx.mapper")
public class PhoneInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneInfoApplication.class);
    }

}

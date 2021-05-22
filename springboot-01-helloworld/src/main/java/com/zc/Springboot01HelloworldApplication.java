package com.zc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//  标注这个类是一个springboot的应用
@SpringBootApplication
public class Springboot01HelloworldApplication {
    //该方法返回一个ConfigurableApplicationContext对象
    //参数一：应用入口的类  参数二：命令行参数
    public static void main(String[] args) {
        SpringApplication.run(Springboot01HelloworldApplication.class, args);
    }

}

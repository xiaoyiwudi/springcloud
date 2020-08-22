/**
 * Author:ysx
 * Date:2020/8/22/02210:01
 * FileName:ActiveApplication
 */


package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ActiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActiveApplication.class,args);
    }
}

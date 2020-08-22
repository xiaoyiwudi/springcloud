/**
 * Author:ysx
 * Date:2020/8/22/02210:24
 * FileName:Custome
 */


package com.qf.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.qf.Feign.SearchFeign;
import com.qf.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customer")
public class Custom {
    @Resource
    private EurekaClient eurekaClient;

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private SearchFeign searchFeign;

    @GetMapping("/hello")
    public String hello(){
   /*     //1. 通过Eureka获取到Search服务的地址信息
        InstanceInfo search = eurekaClient.getNextServerFromEureka("SEARCH", false);
        String ipAddr = search.getIPAddr();
        int port = search.getPort();
        //2. 通过RestTemplate调用即可.
        String result = restTemplate.getForObject("http://" + ipAddr + ":" + port + "/search/hello", String.class);*/

        // 引用Ribbon时调用
        //String result = restTemplate.getForObject("http://SEARCH/search/hello", String.class);
        //引入feign
        String result2 = searchFeign.search();
        //3. 返回
        return result2;
    }

    @GetMapping("/customer/{id}")
    public Customer findById(@PathVariable Integer id){
        return searchFeign.findById(id);
    }

    @GetMapping("/getCustomer")
    public Customer getCustomer(@RequestParam Integer id, @RequestParam String name){
        return searchFeign.getCustomer(id,name);
    }

    @GetMapping("/save")            // 会自动转换为POST请求  405
    public Customer save(Customer customer){
        return searchFeign.save(customer);
    }

}

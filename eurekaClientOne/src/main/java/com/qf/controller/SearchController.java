/**
 * Author:ysx
 * Date:2020/8/22/02210:08
 * FileName:SearchController
 */


package com.qf.controller;

import com.qf.entity.Customer;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/search")
public class SearchController {

    @GetMapping("/hello")
    public String hello(){
        return "SEARCH：Hello!!";
    }


    @GetMapping("/hello/{id}")
    public Customer findById(@PathVariable Integer id){
        return new Customer(1,"张三",23);
    }

    @GetMapping("/getCustomer")
    public Customer getCustomer(@RequestParam Integer id, @RequestParam String name){
        return new Customer(id,name,23);
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer){
        return customer;
    }
}

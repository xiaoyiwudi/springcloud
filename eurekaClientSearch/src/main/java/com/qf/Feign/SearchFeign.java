package com.qf.Feign;

import com.qf.entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("SEARCH")   // 指定服务名称
public interface SearchFeign {

    // value -> 目标服务的请求路径，method -> 映射请求方式
    @GetMapping(value = "/search/hello")
    String search();

    @RequestMapping(value = "/search/hello/{id}",method = RequestMethod.GET)
    Customer findById(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "/search/getCustomer",method = RequestMethod.GET)
    Customer getCustomer(@RequestParam(value = "id") Integer id, @RequestParam(value = "name") String name);

    @RequestMapping(value = "/search/save",method = RequestMethod.POST)
    Customer save(@RequestBody Customer customer);

}

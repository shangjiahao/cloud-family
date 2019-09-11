package com.jiahao.ribbon.controller;

import com.jiahao.ribbon.feign.ClientServiceFeign;
import com.jiahao.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloControler
 * @Description TODO
 * @Author 尚嘉豪
 * @Date 2019/9/10 16:58
 * @Version 1.0
 **/
@RestController
public class HelloControler {
    @Autowired
    HelloService helloService;
    @Autowired
    ClientServiceFeign clientServiceFeign;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }

    @GetMapping(value = "/feign/hi")
    public String hiByFeign(@RequestParam String name) {
        return clientServiceFeign.sayHiFromClientOne(name);
    }
}

package com.jiahao.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName HelloService
 * @Description 远程调用的一直形式 restTemplate+ribbon
 * @Author 尚嘉豪
 * @Date 2019/9/10 16:52
 * @Version 1.0
 **/
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        return restTemplate.getForObject("http://jiahao-client-1/hi?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}

package com.jiahao.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ClientController
 * @Description TODO
 * @Author 尚嘉豪
 * @Date 2019/9/10 15:37
 * @Version 1.0
 **/
@RestController
public class ClientController {
    @Value("${server.port}")
    private String port;
    @Value("${foo}")
    private String foo;

    @RequestMapping(value = "/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @RequestMapping(value = "/foo")
    public String remoteConfig(){
        return "git config: foo->"+foo;
    }
}

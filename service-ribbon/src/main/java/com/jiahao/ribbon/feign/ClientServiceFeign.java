package com.jiahao.ribbon.feign;

import com.jiahao.ribbon.feign.failback.ClientServiceFailback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName ClientServiceFeign
 * @Description TODO
 * @Author 尚嘉豪
 * @Date 2019/9/10 20:23
 * @Version 1.0
 **/
@FeignClient(value = "jiahao-client-1",fallback = ClientServiceFailback.class)
public interface ClientServiceFeign {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}

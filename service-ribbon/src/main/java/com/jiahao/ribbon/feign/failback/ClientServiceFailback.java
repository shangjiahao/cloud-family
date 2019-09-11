package com.jiahao.ribbon.feign.failback;

import com.jiahao.ribbon.feign.ClientServiceFeign;
import org.springframework.stereotype.Component;

/**
 * @ClassName ClientServiceFailback
 * @Description TODO
 * @Author 尚嘉豪
 * @Date 2019/9/11 10:37
 * @Version 1.0
 **/
@Component
public class ClientServiceFailback implements ClientServiceFeign {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}

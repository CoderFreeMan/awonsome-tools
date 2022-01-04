package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangdejun
 * @date 2022/1/4 12:58
 */
@RestController
@RequestMapping(value = "/redis")
public class RedisController {
    @GetMapping(value = "hello")
    public void test() {
        System.out.println("Hello redis");
    }
}

package com.cc.app.gws.controller;


import com.cc.app.gws.service.HelloService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gws/api/hello")
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/get")
    public String get(@RequestParam(name = "name") String name){
        logger.info("hello, {}", name);
        return "hello, " + name;
    }

    @PostMapping(value = "/deduct")
    public String deduct(@RequestParam(name = "name") String name){
        helloService.deduct(name);
        return "hello, " + name;
    }
}

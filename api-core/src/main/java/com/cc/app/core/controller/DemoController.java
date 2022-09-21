package com.cc.app.core.controller;


import com.cc.app.core.feign.GwsService;
import com.cc.app.core.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/core/api/demo")
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    @GetMapping(value = "/get")
    public String get(@RequestParam(name = "name", required = false) String name){
        try {
            return demoService.createOrder(name);
        }catch(Exception e){
            e.printStackTrace();
            return "访问失败";
        }
    }

}

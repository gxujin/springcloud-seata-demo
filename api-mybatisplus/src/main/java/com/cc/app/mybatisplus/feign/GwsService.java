package com.cc.app.mybatisplus.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "api-gws", path = "/gws/api/hello")
public interface GwsService {

    @GetMapping("/get")
    String hello(@RequestParam(name="name") String name);

    @PostMapping("/deduct")
    String deduct(@RequestHeader(name = "xid") String xid, @RequestParam(name="name") String name);
}

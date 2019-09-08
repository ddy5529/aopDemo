package com.ddy.aop;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "HelloController")
@RestController
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @ApiOperation("/第一个请求")
    @LogRecord
    @GetMapping("/hello")
    public String hello(){
        LogUtils.printDebugLog(logger,"hello");
        return "hello";
    }
}

package com.mw.concurrency.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author WangCH
 * @create 2018-03-21 13:31
 */
@Controller
@Slf4j
public class TestController {

    //volatile int i = 0;

    @RequestMapping("test")
    @ResponseBody
    public String test(){

        return "test";
    }
}

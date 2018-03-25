package com.mw.concurrency.example.threadLocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author WangCH
 * @create 2018-03-22 0:20
 */
@Controller
@RequestMapping(value = "threadLocal")
public class ThreadLocalController {

    @RequestMapping(value = "test")
    @ResponseBody
    public Long test(){
        return RequestHolder.getId();
    }
}

package com.qin.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: community
 * @description:
 * @author: qin
 * @create: 2019-11-10 18:38
 **/
@Controller
public class BookController {
    @RequestMapping("/book")
    public String book(){
        return "/deleteBook";
    }
}

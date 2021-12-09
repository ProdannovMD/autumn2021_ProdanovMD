package com.netcracker.lesson;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "hello_world";
    }

    public static void main(String[] args) {
        System.out.println("test");
        http://www.javapoint.ru
        return;
    }
}

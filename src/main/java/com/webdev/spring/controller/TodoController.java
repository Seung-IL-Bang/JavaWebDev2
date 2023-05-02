package com.webdev.spring.controller;

import com.webdev.spring.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {

    @RequestMapping("/list")
    public void list() {
        log.info("todo list...");
    }

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public void registerGET() {
        log.info("GET todo register...");
    }

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @PostMapping("/register")
    public void registerPOST(TodoDTO todoDTO) { // JSON -> DTO 자동으로 형변환이 이루어진다. cf. finished: on 으로 전달되는 불리언 값은 true 로 매핑된다.
        log.info("POST todo register...");
        log.info(todoDTO);

    }
}

package com.webdev.spring.controller;

import com.webdev.spring.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public void hello() {
        log.info("hello....");
    }

    // 단순 파라미터 자동 수집: 전달되지 않은 파라미터가 존재하면 400 error 발생
    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("ex1...");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    // @RequestParam: 전달되지 않은 파라미터에 대한 기본값 설정 가능 -> 400 error 방지
    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "AAA") String name,
                    @RequestParam(name = "age", defaultValue = "25") int age) {
        log.info("ex2...");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    // LocalDate 를 파라미터로 자동 변환 & 수집
    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        log.info("ex3...");
        log.info("dueDate: " + dueDate);
    }

    // Model 파라미터 -> 뷰(View) 에 데이터 전달
    @GetMapping("/ex4")
    public void ex4(Model model) {
        log.info("-----------------");
        model.addAttribute("message", "Hello World");
    }

    // 객체는 자동 전달; @ModelAttribute -> jsp 에서 사용할 변수명 설정 가능
    @GetMapping("/ex4_1")
    public void ex4(@ModelAttribute("dto") TodoDTO todoDTO, Model model) {
        log.info("-----------------");
        model.addAttribute("message", "Hello World");
    }

    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name", "ABC"); // 쿼리 스트링으로 키=값 전달
        redirectAttributes.addFlashAttribute("result", "success"); // 일회용 데이터로 JSP 에 전달

        return "redirect:/ex6"; // 접두사 'redirect:경로' 문자열을 반환하면서 리다이렉트
    }

    @GetMapping("/ex6")
    public void ex6() {

    }

    @GetMapping("/ex7")
    public void ex7(String p1, int p2) {
        log.info("p1: " + p1);
        log.info("p2: " + p2);
    }
}

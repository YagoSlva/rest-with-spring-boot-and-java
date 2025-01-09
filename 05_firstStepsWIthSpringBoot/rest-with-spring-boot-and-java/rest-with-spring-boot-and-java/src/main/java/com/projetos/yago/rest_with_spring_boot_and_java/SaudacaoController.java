package com.projetos.yago.rest_with_spring_boot_and_java;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class SaudacaoController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @GetMapping("/saudacao")   
    public Saudacao saudacao(
        @RequestParam(value = "name", defaultValue = "World")
        String name) {
            return new Saudacao(counter.incrementAndGet(), String.format(template, name));
        }
}

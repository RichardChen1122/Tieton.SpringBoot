package com.siemens.kpiscriptengine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/api/hello")
    public void hello() {

    }
}
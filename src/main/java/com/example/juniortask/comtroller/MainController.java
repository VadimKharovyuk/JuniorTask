package com.example.juniortask.comtroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/{hash}")
    public String  getByhash(@PathVariable String hash){
        return hash;

    }
}

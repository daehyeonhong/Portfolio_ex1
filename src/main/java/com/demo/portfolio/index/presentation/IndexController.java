package com.demo.portfolio.index.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Optional;

@Controller
public class IndexController {
    @GetMapping(value = {"/"})
    public ResponseEntity<String> index() {
        return ResponseEntity.of(Optional.of("ok"));
    }
}

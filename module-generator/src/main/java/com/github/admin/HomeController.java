package com.github.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v0.1
 * @Autheror wanglei
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }
}

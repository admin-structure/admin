package org.apache.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index controller
 * @version v0.1
 * @Autheror wanglei
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String index() {
        return "index.html";
//        return "redirect:/pages/index.html";
    }

    @GetMapping("login")
    public String login(){
        return "login.html";
    }
}

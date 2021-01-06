package com.github.admin;

import com.github.admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public @ResponseBody String greeting() {
        accountService.queryAll().forEach(a -> System.out.println(a.toString()));
        return "Hello, World";
    }
}

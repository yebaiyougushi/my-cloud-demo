package com.example.userservice.web;


import com.example.userservice.config.PatternProperties;
import com.example.userservice.pojo.User;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
// @RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    // @Value("${pattern.dateformat}")
    // private String dateformat;

    @Autowired
    private PatternProperties properties;

    @GetMapping("prop")
    public PatternProperties properties(){
        return properties;
    }

    @GetMapping("now")
    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,
                          @RequestHeader(value = "Truth", required = false) String truth) {
        System.out.println("truth: " + truth);
        User user = userService.queryById(id);
        System.out.println(user);
        return user;
    }
}

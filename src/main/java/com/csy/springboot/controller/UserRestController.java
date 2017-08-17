package com.csy.springboot.controller;

import com.csy.springboot.domain.Mail;
import com.csy.springboot.service.UserService;
import com.csy.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/api/login", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity login(@RequestBody User user){
        return userService.login(user);
    }
    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity register(@RequestBody User user){
        return userService.register(user);
    }
    @RequestMapping(value = "/api/code", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity mailCode(@RequestBody Mail mail) {
        return userService.sendCode(mail);
    }
}

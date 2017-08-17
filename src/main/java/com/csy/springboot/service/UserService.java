package com.csy.springboot.service;

import com.csy.springboot.domain.Mail;
import com.csy.springboot.domain.User;
import org.springframework.http.ResponseEntity;

/**
 * 城市业务逻辑接口类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
public interface UserService {


    ResponseEntity login(User user);

    ResponseEntity sendCode(Mail mail);

    ResponseEntity register(User user);
}

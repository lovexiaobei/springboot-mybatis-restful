package com.csy.springboot.service.impl;

import com.csy.springboot.Md5.Md5Utils;
import com.csy.springboot.dao.UserDao;
import com.csy.springboot.domain.*;
import com.csy.springboot.service.UserService;
import org.spring.springboot.domain.*;
import com.csy.springboot.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 城市业务逻辑实现类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseEntity login(User user) {
        String password = Md5Utils.EncoderByMd5(user.getPwd());
        ResponseEntity entry;
        User user1 = userDao.findByName(user.getUsername());
        if (!password.equals(user1.getPwd())) {
            ErrorResult result = new ErrorResult();
            result.setResult("密码错误");
            result.setStatus(403);
            entry = ResponseEntity.status(400).body(result);

        } else {
            userDao.deleteToken(user1.getId());
            Token token = new Token();
            token.setToken(UUID.randomUUID().toString());
            token.setUser_id(user1.getId());
            userDao.addToken(token);
            entry = ResponseEntity.ok(userDao.findToken(user1.getId()));
        }
        return entry;
    }

    @Override
    public ResponseEntity sendCode(Mail mail) {

        if (!mail.isEmail()) {
            ErrorResult errorResult = new ErrorResult();
            errorResult.setStatus(400);
            errorResult.setResult("邮箱格式不正确");
            return ResponseEntity.status(400).body(errorResult);
        } else {
            int code = Integer.valueOf(Md5Utils.getToken());
            try {
                MailUtils.sendEmail(mail.getMail(), code);
            } catch (Exception e) {
                e.printStackTrace();
                ErrorResult error = new ErrorResult();
                error.setStatus(400);
                error.setResult("发送邮箱失败");
                return ResponseEntity.status(400).body(error);
            }
            mail.setCode(code);
            userDao.deleteMail(mail.getMail());
            userDao.insertMail(mail);
            Result result = new Result();
            result.setStatus(201);result.setResult("发送邮箱验证码成功");
            return ResponseEntity.status(201).body(result);


        }
    }

    @Override
    public ResponseEntity register(User user) {
        String password = Md5Utils.EncoderByMd5(user.getPwd());
        user.setPwd(password);
        ResponseEntity entry;
        if (userDao.findByName(user.getUsername()) != null) {
            ErrorResult result = new ErrorResult();
            result.setStatus(403);
            result.setResult("账户已存在");
            entry = ResponseEntity.status(400).body(result);
        } else {
            userDao.saveUser(user);
            Token token = new Token();
            token.setToken(UUID.randomUUID().toString());
            token.setUser_id(user.getId());
            userDao.addToken(token);
            Token result = userDao.findToken(user.getId());
            entry = ResponseEntity.ok(result);
        }
        return entry;
    }
}

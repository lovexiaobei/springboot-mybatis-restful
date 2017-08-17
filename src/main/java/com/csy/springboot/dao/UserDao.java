package com.csy.springboot.dao;

import org.apache.ibatis.annotations.Param;
import com.csy.springboot.domain.Mail;
import com.csy.springboot.domain.Token;
import com.csy.springboot.domain.User;

import java.util.List;

/**
 * Created by chenshengyu
 * on 2017/8/11.
 */
public interface UserDao {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<User> findAllUser();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    User findById(@Param("id") Long id);

    User findByName(@Param("username") String username);

    Long saveUser(User city);

    Long updateUser(User city);

    Long deleteUser(Long id);

    Long addToken(Token token);

    boolean checkToken(Token token);

    Token findToken(@Param("user_id") Long user_id);

    Long deleteToken(@Param("user_id") Long user_id);

    Long insertMail(Mail mail);

    Long deleteMail(String mail);
}

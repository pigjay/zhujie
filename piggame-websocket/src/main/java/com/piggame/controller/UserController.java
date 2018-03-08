package com.piggame.controller;

import com.piggame.entity.User;
import com.piggame.util.UserListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author:zhujie
 * @Date: Create in 17:04 2018/3/1
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public @ResponseBody Object login(User user, HttpServletRequest request){
        boolean login = UserListUtil.checkUser(user.getUsername(),user.getPassword());
        if (login){
            HttpSession session = request.getSession();
            session.setAttribute("user",UserListUtil.getUserByName(user.getUsername()));
        }
        return login;
    }

}

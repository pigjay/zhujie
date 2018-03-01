package com.piggame.util;

import com.piggame.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zhujie
 * @Date: Create in 16:52 2018/3/1
 **/
public class UserListUtil {

    private static final List<User> users = new ArrayList<User>();
    static {
        users.add( new User(0L,"zhujie","123456"));
        users.add(new User(1L,"liguoyang","123456"));
        users.add( new User(2L,"sunyue","123456"));
        users.add(new User(3L,"gaoweili","123456"));
    }

    public static User getUserById(Long id){
        return users.get(id.intValue());
    }

    public static User getUserByName(String username){
        for (User user : users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public static boolean checkUser(String username,String password){
        User user = getUserByName(username);
        if(user == null){
            return false;
        }
        if(user.getPassword().equals(password)){
            return true;
        }

        return false;
    }
}

package com.piggame.manager;

import com.piggame.entity.Room;
import com.piggame.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zhujie
 * @Date: Create in 16:12 2018/3/2
 **/
public class RoomManager {

    private static Map<String,Room> roomMap = new HashMap<String, Room>();

    /**
     * 创建房间
     * @param user 创建者
     * @return
     */
    public static String BuildRoom(User user){
        Room room = new Room();
        room.joinRoom(user);
        room.setId(user.getId());
        roomMap.put(room.getId().toString(),room);
        return room.getId().toString();
    }

    public static void removeRoom(String roomId){
        roomMap.remove(roomId);
    }
}


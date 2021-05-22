package com.zc.utils;

import java.util.UUID;

public class UUIDUtils {

    static Integer id = 7;
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public static Integer getID() {
        return id++;
    }
}

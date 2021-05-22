package com.zc;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<Integer,Integer> map= new HashMap<Integer,Integer>();
        Integer put1 = map.put(1, 1);
        System.out.println(put1);
        Integer put2 = map.put(1, 1);
        System.out.println(put2);
    }

}

package com.hxq;

import redis.clients.jedis.Jedis;

public class testjesid {
    public static void main(String[] args) {
       Jedis jedis = new Jedis("118.178.189.82",6379);
       jedis.auth("123");
        System.out.println(jedis.ping());
        System.out.println(jedis.get("linux"));
        System.out.println(jedis.get("name"));
    }
}

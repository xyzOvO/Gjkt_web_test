//package com.xyz66.redis;
//
//import org.junit.jupiter.api.Test;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//
//public class RedisJava {
//    public static void main(String[] args) {
//        // 连接本地的 Redis 服务
//        // jedis的直连
//        Jedis jedis = new Jedis("127.0.0.1",6379);
//        jedis.set("name", "redis测试");
//        System.out.println("redis 存储的字符串为: "+ jedis.get("name"));
//    }
//    @Test
//    public void cs(){
//        // jedis的连接池
//        // 初始化连接池
//        JedisPoolConfig config=new JedisPoolConfig();
//        JedisPool jedisPool=new JedisPool(config,"127.0.0.1",6379);
//
//        Jedis jedis=null;
//        try{
//            jedis=jedisPool.getResource(); // 获取连接
//            jedis.set("name", "redis测试"); // 设置值
//            String value=jedis.get("name"); // 获取值
//            System.out.println(value);
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            if(jedis!=null){
//                jedis.close();
//            }
//            if(jedisPool!=null){
//                jedisPool.close();
//            }
//        }
//    }
//}

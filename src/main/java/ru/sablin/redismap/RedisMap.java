package ru.sablin.redismap;

import redis.clients.jedis.Jedis;
import java.util.Map;

public class RedisMap implements Map<String, String> {

    private Jedis client;
    private String redisHKey;

    public RedisMap(String host, int port) {
        client = new Jedis(host, port);
    }

    @Override
    public String get(Object key) {
        return client.hget(redisHKey, key.toString());
    }

    @Override
    public String put(String key, String value) {
        var old = client.hget(redisHKey, key);
        client.hset(redisHKey, key, value);
        return old;
    }
}
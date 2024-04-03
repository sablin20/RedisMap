package ru.sablin.redismap;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class RedisMap implements Map<String, String> {
    private final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    private final RedissonClient redisson;

    public RedisMap(String host, int port) {
        Config config = new Config();
        config.useSingleServer().setAddress(host + ":" + port);
        redisson = Redisson.create(config);
    }

    @Override
    public String get(Object key) {
        return map.get(key);
    }

    @Override
    public String put(String key, String value) {
        return map.put(key, value);
    }
}
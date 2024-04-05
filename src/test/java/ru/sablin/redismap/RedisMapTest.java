package ru.sablin.redismap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RedisMapTest {

    @Test
    public void test() {
        var redisMap = new RedisMap("localhost", 8080);
        var key = "key";
        var value = "value";

        // Вызов метода put
        var oldValue = redisMap.put(key, value);

        // Проверка, что метод put вернул null, так как ключ не существовал ранее
        assertNull(oldValue);

        // Проверка, что значение было установлено в Redis
        assertEquals(value, redisMap.get(key));
    }
}
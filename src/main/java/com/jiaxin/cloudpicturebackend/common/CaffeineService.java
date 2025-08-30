package com.jiaxin.cloudpicturebackend.common;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.util.Random;

/**
 * 本地缓存服务
 */
@Service
public class CaffeineService {
    // 过期时间范围
    private static final int MIN_TIMEOUT = 5;
    private static final int MAX_TIMEOUT = 15;

    /**
     * 本地缓存实例
     */
    private final Cache<String, String> cache = Caffeine.newBuilder()
            .initialCapacity(1024) // 初始化容量
            .maximumSize(10_000L) // 最大 10000 条
            .expireAfterWrite(Duration.ofMinutes(generateRandomTimeout())) // 随机过期时间
            .build();

    /**
     * 生成随机超时时间(5-15分钟)
     * @return 随机超时时间(分钟)
     */
    private int generateRandomTimeout() {
        Random rand = new Random();
        return MIN_TIMEOUT + rand.nextInt(MAX_TIMEOUT - MIN_TIMEOUT + 1);
    }

    /**
     * 获取缓存值
     * @param key 缓存键
     * @return 缓存值
     */
    public String getIfPresent(String key) {
        return cache.getIfPresent(key);
    }

    /**
     * 设置缓存值
     * @param key 缓存键
     * @param value 缓存值
     */
    public void put(String key, String value) {
        cache.put(key, value);
    }

    /**
     * 批量获取缓存值
     * @param keys 缓存键集合
     * @return 缓存值映射
     */
    public java.util.Map<String, String> getAllPresent(Iterable<String> keys) {
        return cache.getAllPresent(keys);
    }

    /**
     * 删除缓存
     * @param key 缓存键
     */
    public void invalidate(String key) {
        cache.invalidate(key);
    }

    /**
     * 批量删除缓存
     * @param keys 缓存键集合
     */
    public void invalidateAll(Iterable<String> keys) {
        cache.invalidateAll(keys);
    }

    /**
     * 清空所有缓存
     */
    public void invalidateAll() {
        cache.invalidateAll();
    }

    /**
     * 获取缓存统计信息
     * @return 缓存统计信息
     */
    public com.github.benmanes.caffeine.cache.stats.CacheStats stats() {
        return cache.stats();
    }
}

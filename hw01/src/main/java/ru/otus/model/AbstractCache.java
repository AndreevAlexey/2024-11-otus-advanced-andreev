package ru.otus.model;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<T> {

    private final Map<String, SoftReference<T>> cacheMap = new HashMap<>();


    public boolean isCached(String key) {
        return cacheMap.containsKey(key);
    }

    public void addToCache(String cacheName, T data) {
        cacheMap.put(cacheName, new SoftReference<>(data));
    }

    public T getFromCache(String cacheName) {
        if (!isCached(cacheName)) {
            return null;
        }
        return
                cacheMap.get(cacheName).get();
    }

}


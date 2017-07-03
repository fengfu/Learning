package io.fengfu.learning.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * Created by fengfu on 2017/3/10.
 */
public class LoadingCacheDemo {
    private static LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(1000).build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    if ("key".equals(key)) {
                        return "key return result";
                    } else {
                        return "get-if-absent-compute";
                    }
                }
            });

    public static String get(String key){
        return cache.getIfPresent(key);
    }
}

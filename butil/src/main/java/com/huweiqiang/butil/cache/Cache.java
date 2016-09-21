package com.huweiqiang.butil.cache;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/6.
 */
public interface Cache<K, V> {
    void put(K k, V v);

    V get(K k);
}

package com.cache.study;

public interface DataStore<K, V> {

    enum PutStatus {
        PUT
    }

    ValueHolder<V> get(K key);

    PutStatus put(K key, V value);

    ValueHolder<V> remove(K key);

    void clear();


}

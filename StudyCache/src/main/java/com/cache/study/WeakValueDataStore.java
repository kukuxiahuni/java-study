package com.cache.study;

import java.util.concurrent.ConcurrentHashMap;

public class WeakValueDataStore<K, V> implements DataStore<K, V> {

    ConcurrentHashMap<K, ValueHolder<V>> map = new ConcurrentHashMap<K, ValueHolder<V>>();


    public ValueHolder<V> get(K key) {
        return this.map.get(key);
    }

    public PutStatus put(K key, V value) {
        ValueHolder<V> valueHolder = new WeakValueHolder<V>(value);
        this.map.put(key, valueHolder);
        return PutStatus.PUT;
    }

    public ValueHolder<V> remove(K key) {
        return this.map.remove(key);
    }

    public void clear() {
        this.map.clear();
    }
}

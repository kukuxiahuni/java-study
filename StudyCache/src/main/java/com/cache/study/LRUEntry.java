package com.cache.study;

import java.util.Map;

public class LRUEntry<K, V extends ValueHolder<?>> implements Map.Entry<K, ValueHolder<?>> {

    final K key;
    ValueHolder<?> value;

    LRUEntry<K, ValueHolder<?>> pre;
    LRUEntry<K, ValueHolder<?>> next;

    public LRUEntry(K key, ValueHolder<?> value) {
        super();
        this.key = key;
        this.value = value;
    }

    public LRUEntry<K, ValueHolder<?>> getPre() {
        return pre;
    }

    public void setPre(LRUEntry<K, ValueHolder<?>> pre) {
        this.pre = pre;
    }

    public LRUEntry<K, ValueHolder<?>> getNext() {
        return next;
    }

    public void setNext(LRUEntry<K, ValueHolder<?>> next) {
        this.next = next;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public ValueHolder<?> getValue() {
        return this.value;
    }

    @Override
    public ValueHolder<?> setValue(ValueHolder<?> value) {
        ValueHolder<?> oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}

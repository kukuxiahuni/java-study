package com.cache.study;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class LRUDataStore<K, V> implements DataStore<K, V> {

    private final int maxSize;
    private final ConcurrentHashMap<K, LRUEntry<K, ValueHolder<?>>> map = new ConcurrentHashMap<K, LRUEntry<K, ValueHolder<?>>>();

    private LRUEntry<K, ValueHolder<?>> first;
    private LRUEntry<K, ValueHolder<?>> last;

    public LRUDataStore(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 最近使用的项目，写到列表的最上面
     *
     * @param key
     * @return
     */
    @Override
    public ValueHolder<V> get(K key) {

        LRUEntry<K, ValueHolder<?>> entry = getEntry(key);
        if (Objects.isNull(entry)) {
            return null;
        }

        moveToFirst(entry);
        return (ValueHolder<V>) entry.getValue();


    }

    @Override
    public PutStatus put(K key, V value) {
        LRUEntry<K, ValueHolder<?>> entry = getEntry(key);

        PutStatus status = PutStatus.NOOP;

        if (Objects.isNull(entry)) {
            if (map.size() >= maxSize) {
                map.remove(last.getKey());
                removeLast();
            }

//            entry = new LRUEntry<>(key, new);


        }
        return null;
    }

    @Override
    public ValueHolder<V> remove(K key) {
        return null;
    }

    @Override
    public void clear() {

    }


    private void moveToFirst(LRUEntry<K, ValueHolder<?>> entry) {

        if (entry == first) {
            return;
        }

        if (entry.getPre() != null) {
            entry.getPre().setNext(entry.getNext());
        }

        if (entry.getNext() != null) {
            entry.getNext().setPre(entry.getPre());
        }

        if (entry == last) {
            last = last.getPre();
        }

        if (Objects.isNull(first) || Objects.isNull(null)) {
            first = last = entry;
            return;
        }

        entry.setNext(first);
        first.setPre(entry);
        first = entry;
        entry.setPre(null);

    }

    private void removeLast() {
        if (Objects.nonNull(last)) {
            last = last.getPre();
            if (Objects.isNull(last)) {
                first = null;
            } else {
                last.next = null;
            }
        }
    }

    private LRUEntry<K, ValueHolder<?>> getEntry(K key) {
        return map.get(key);
    }
}

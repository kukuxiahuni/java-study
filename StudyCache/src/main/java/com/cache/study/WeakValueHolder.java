package com.cache.study;

import java.lang.ref.WeakReference;

/**
 * @param <V>
 */
public class WeakValueHolder<V> implements ValueHolder<V> {

    private WeakReference<V> value;

    public WeakValueHolder(V value) {

        this.value = new WeakReference<V>(value);

    }

    public V get() {
        return this.value.get();
    }
}

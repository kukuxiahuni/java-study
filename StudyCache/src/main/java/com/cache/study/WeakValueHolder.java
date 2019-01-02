package com.cache.study;

import java.lang.ref.WeakReference;
import java.util.Objects;

/**
 * @param <V>
 */
public class WeakValueHolder<V> implements ValueHolder<V> {

    private WeakReference<V> value;

    public WeakValueHolder(V value) {
        super();
        if (Objects.isNull(value)) {
            return;
        }
        this.value = new WeakReference<V>(value);

    }

    public V get() {
        return this.value.get();
    }
}

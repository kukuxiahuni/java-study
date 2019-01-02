package com.cache.study;

public class BasicValueHolder<V> implements ValueHolder<V> {
	private final V refValue;

	public BasicValueHolder(final V value) {
		refValue = value;
	}

	@Override
	public V value() {
		return refValue;
	}

}
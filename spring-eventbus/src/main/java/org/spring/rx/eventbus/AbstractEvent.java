package org.spring.rx.eventbus;

public abstract class AbstractEvent<T> implements Event<T>{

    private final T value;

    public AbstractEvent(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }
}

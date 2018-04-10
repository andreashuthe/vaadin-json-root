package org.spring.rx.eventbus;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public interface EventBus {
    void post(@NonNull Event event);

    <T> Observable<T> observable(@NonNull Class<T> eventClass);
}

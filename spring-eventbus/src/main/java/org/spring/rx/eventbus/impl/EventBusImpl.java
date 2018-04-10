package org.spring.rx.eventbus.impl;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import org.spring.rx.eventbus.Event;
import org.spring.rx.eventbus.EventBus;

public class EventBusImpl implements EventBus {

    private final Subject<Object> bus;

    public EventBusImpl() {
        this.bus = PublishSubject.create().toSerialized();
    }

    @Override
    public void post(@NonNull Event event) {
        if (this.bus.hasObservers()) {
            this.bus.onNext(event);
        }
    }

    @Override
    public <T> Observable<T> observable(Class<T> eventClass) {
        return this.bus
                .filter(o -> o != null) // Filter out null objects, better safe than sorry
                .filter(eventClass::isInstance) // We're only interested in a specific event class
                .cast(eventClass); // Cast it for easier usage
    }
}

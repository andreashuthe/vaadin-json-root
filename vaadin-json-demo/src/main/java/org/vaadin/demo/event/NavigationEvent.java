package org.vaadin.demo.event;

import org.spring.rx.eventbus.AbstractEvent;

public class NavigationEvent extends AbstractEvent<String> {

    public NavigationEvent(String value) {
        super(value);
    }
}

package org.vaadin.demo.configuration;

import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringNavigator;

@UIScope
public class CustomSpringNavigator extends SpringNavigator {
    @Override
    public void navigateTo(String navigationState) {
        if (!"".equals(navigationState)) {
            super.navigateTo(navigationState);
        }
    }
}

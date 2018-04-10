package org.vaadin.demo.configuration;

import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.annotation.EnableVaadinNavigation;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringNavigator;
import org.spring.rx.eventbus.EventBus;
import org.spring.rx.eventbus.impl.EventBusImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;
import org.vaadin.demo.ui.UIUpdater;
import org.vaadin.mvp.base.presenter.BasePresenter;

@Configuration
@EnableAsync
@EnableVaadin
@EnableVaadinNavigation
@ComponentScan(basePackages = {
        "org.vaadin.mvp",
        "org.vaadin.demo.ui",
        "org.vaadin.demo.presenter",
        "org.vaadin.demo.view"
})
public class WebConfig {
    @Bean(name = BasePresenter.UI_SCOPE_EVENTBUS)
    @UIScope
    public EventBus uiScopeEventBus() {
        return new EventBusImpl();
    }

    @Bean(name = "uiUpdater")
    @UIScope
    public UIUpdater uiUpdater() {
        return new UIUpdater();
    }

    @Bean
    @UIScope
    @Primary
    public SpringNavigator vaadinNavigator() {
        return new CustomSpringNavigator();
    }
}

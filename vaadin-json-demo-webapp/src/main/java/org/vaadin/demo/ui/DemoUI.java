package org.vaadin.demo.ui;


import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import lombok.Getter;
import org.spring.rx.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.vaadin.demo.event.NavigationEvent;
import org.vaadin.demo.presenter.navigation.VaadinNavigationPresenter;
import org.vaadin.mvp.base.presenter.BasePresenter;
import org.vaadin.mvp.base.presenter.VaadinNavigatablePresenter;
import org.vaadin.viritin.layouts.MCssLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

@SpringUI
@Title("date-time-fields Add-on Demo")
@SpringViewDisplay
@Theme("demotheme")
@Push
@SuppressWarnings("serial")
public class DemoUI extends UI implements ViewDisplay {

    @Autowired private VaadinNavigationPresenter navigationPresenter;
    @Autowired @Qualifier(value = BasePresenter.UI_SCOPE_EVENTBUS) EventBus eventBus;
    @Autowired @Getter SpringViewProvider viewProvider;

    private MCssLayout header;
    private MCssLayout content;
    private MCssLayout footer;

    @Override
    protected void init(VaadinRequest request) {
        initBaseContent();
        initNavigationPresenter();

        this.eventBus
                .observable(NavigationEvent.class)
                .subscribe(event -> {
                    navigate(event.getValue());
                    // Handle event
                });
    }

    private void initBaseContent() {
        header = new MCssLayout();
        content = new MCssLayout();
        footer = new MCssLayout();

        final MVerticalLayout root = new MVerticalLayout().withSpacing(false).withMargin(false).with(header, content, footer);
        setContent(root);
    }


    private void initNavigationPresenter() {
        navigationPresenter.construct();
        header.addComponent(navigationPresenter.getView());
    }


    @Override
    public void showView(View view) {
        if (view instanceof VaadinNavigatablePresenter) {
            content.removeAllComponents();
            content.add((Component) ((VaadinNavigatablePresenter) view).getView());
        }
    }

    private void navigate (String presenterName) {
        getNavigator().navigateTo(presenterName);
    }

}

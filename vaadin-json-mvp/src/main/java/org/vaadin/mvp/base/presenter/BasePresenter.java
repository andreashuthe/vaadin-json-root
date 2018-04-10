package org.vaadin.mvp.base.presenter;

import lombok.Getter;
import org.spring.rx.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.vaadin.mvp.base.view.View;

import javax.annotation.PreDestroy;

/**
 * Created by huth on 08.06.2017.
 */
public abstract class BasePresenter<T extends View> implements Presenter<T> {
    public static final String UI_SCOPE_EVENTBUS ="uiScopeBus";

    @Autowired @Qualifier(value = UI_SCOPE_EVENTBUS) @Getter EventBus eventBus;

    private final @Getter T view;

    private boolean initState = false;

    protected BasePresenter(T view) {
        Assert.notNull(view);
        this.view = view;
    }

    protected abstract void init();

    public void construct() {
        if (!initState) {
            getView().init();
            init();
            this.initState = true;
        }
    }
}

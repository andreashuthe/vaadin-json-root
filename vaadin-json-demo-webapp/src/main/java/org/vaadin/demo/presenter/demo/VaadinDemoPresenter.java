package org.vaadin.demo.presenter.demo;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.demo.view.demo.VaadinDemoView;
import org.vaadin.mvp.base.presenter.VaadinNavigatablePresenter;

@UIScope
@SpringView(name = DemoPresenter.PRESENTER_NAME)
@CommonsLog
public class VaadinDemoPresenter extends DemoPresenter<VaadinDemoView> implements VaadinNavigatablePresenter<VaadinDemoView> {

    @Autowired
    public VaadinDemoPresenter(VaadinDemoView view) {
        super(view);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        construct();
    }
}

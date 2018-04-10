package org.vaadin.demo.presenter.json;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.demo.view.json.VaadinJsonView;
import org.vaadin.mvp.base.presenter.VaadinNavigatablePresenter;

@UIScope
@SpringView(name = JsonPresenter.PRESENTER_NAME)
@CommonsLog
public class VaadinJsonPresenter extends JsonPresenter<VaadinJsonView> implements VaadinNavigatablePresenter<VaadinJsonView> {

    @Autowired
    public VaadinJsonPresenter(VaadinJsonView view) {
        super(view);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        construct();
    }

    //
}

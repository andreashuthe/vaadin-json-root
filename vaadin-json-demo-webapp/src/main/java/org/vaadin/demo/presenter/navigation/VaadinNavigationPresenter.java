package org.vaadin.demo.presenter.navigation;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.demo.view.navigation.VaadinNavigationView;

/**
 * Created by huth on 16.06.2017.
 */
@UIScope
@SpringComponent
public class VaadinNavigationPresenter extends NavigationPresenter<VaadinNavigationView> {
    @Autowired
    public VaadinNavigationPresenter(VaadinNavigationView view) {
        super(view);
    }

    @Override
    protected void navigate(String name) {
        UI.getCurrent().getNavigator().navigateTo(name);
    }

}

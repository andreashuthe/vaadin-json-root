package org.vaadin.demo.presenter.navigation;

import org.springframework.stereotype.Component;
import org.vaadin.demo.event.NavigationEvent;
import org.vaadin.demo.model.menu.MenuModel;
import org.vaadin.demo.model.tree.GenericTreeNode;
import org.vaadin.demo.view.navigation.NavigationView;
import org.vaadin.mvp.base.presenter.BasePresenter;
import org.vaadin.mvp.handler.NavigationHandler;

/**
 * Created by huth on 14.06.2017.
 */
@Component
public abstract class NavigationPresenter<V extends NavigationView> extends BasePresenter<V> {

    @Override
    protected void init() {
        getView().setNavigationHandler(new NavigationHandler() {
            @Override
            public void navigateTo(String springViewName) {
                getEventBus().post(new NavigationEvent(springViewName));
            }
        });
        initMenu();
    }


    private void initMenu(){

        final GenericTreeNode<MenuModel> menuTree = new GenericTreeNode<>();
        final MenuModel root = new MenuModel();
        root.setId(-1L);
        menuTree.setData(root);

        final GenericTreeNode<MenuModel> rootTree = new GenericTreeNode<>();
        final MenuModel rootMenuModel = new MenuModel();
        rootMenuModel.setId(-10L);
        rootMenuModel.setLabel("Root");
        rootTree.setData(rootMenuModel);

        menuTree.addChild(rootTree);

        final GenericTreeNode<MenuModel> dummyChild = new GenericTreeNode<>();
        final MenuModel dummyMenuModel = new MenuModel();
        dummyMenuModel.setId(-20L);
        dummyMenuModel.setLabel("Dummy");
        dummyChild.setData(dummyMenuModel);

        final MenuModel dummyMenuModel1 = new MenuModel();
        dummyMenuModel1.setId(-20L);
        dummyMenuModel1.setLabel("Demo");
        dummyMenuModel1.setClassString("demoPresenter");
        dummyChild.addChild(dummyMenuModel1);

        final MenuModel dummyMenuModel2 = new MenuModel();
        dummyMenuModel2.setId(-30L);
        dummyMenuModel2.setLabel("Json");
        dummyMenuModel2.setClassString("jsonPresenter");
        dummyChild.addChild(dummyMenuModel2);


        menuTree.addChild(dummyChild);

        getView().initMenu(menuTree);
    }

    protected abstract void navigate(String name);

    public NavigationPresenter(V view) {
        super(view);
    }
}

package org.vaadin.demo.presenter.demo;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import org.vaadin.demo.model.ComboBoxData;
import org.vaadin.demo.view.demo.DemoView;
import org.vaadin.mvp.base.presenter.BasePresenter;

@Component
public abstract class DemoPresenter<V extends DemoView> extends BasePresenter<V>{

    final static String PRESENTER_NAME = "demoPresenter";

    public DemoPresenter(V view) {
        super(view);
    }

    @Override
    protected void init() {
        populateData();
    }

    private void populateData() {
        final ComboBoxData comboBoxData1 = new ComboBoxData();
        comboBoxData1.setId(1L);
        comboBoxData1.setName("1 value");

        final ComboBoxData comboBoxData2 = new ComboBoxData();
        comboBoxData2.setId(2L);
        comboBoxData2.setName("2 value");

        final ComboBoxData comboBoxData3 = new ComboBoxData();
        comboBoxData3.setId(3L);
        comboBoxData3.setName("3 value");

        final ComboBoxData comboBoxData4 = new ComboBoxData();
        comboBoxData4.setId(4L);
        comboBoxData4.setName("4 value");

        getView().populateComboBoxData(Lists.newArrayList(comboBoxData1, comboBoxData2, comboBoxData3, comboBoxData4));
    }


}

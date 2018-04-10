package org.vaadin.demo.view.demo;

import org.vaadin.demo.model.ComboBoxData;
import org.vaadin.mvp.base.view.View;

import java.util.List;

public interface DemoView extends View {

    String VIEW_NAME = "demoView";

    void populateComboBoxData(List<ComboBoxData> comboBoxDataList);

}

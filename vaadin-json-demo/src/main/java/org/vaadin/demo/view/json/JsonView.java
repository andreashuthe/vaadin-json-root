package org.vaadin.demo.view.json;

import org.vaadin.mvp.base.view.View;

public interface JsonView extends View {

    String VIEW_NAME = "jsonView";

    void populateComboBoxData(String json);

    void populateGridData(String json);

    void updateLoading();
}

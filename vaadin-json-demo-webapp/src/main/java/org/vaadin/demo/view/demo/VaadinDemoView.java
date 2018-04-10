package org.vaadin.demo.view.demo;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.demo.model.ComboBoxData;
import org.vaadin.mvp.base.view.VaadinView;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.grid.MGrid;
import org.vaadin.viritin.layouts.MHorizontalLayout;

import java.util.List;

@UIScope
@SpringComponent
public class VaadinDemoView extends MHorizontalLayout implements DemoView {

    private MTextField textField;
    private ComboBox comboBox;
    private MGrid grid;

    @Autowired
    public VaadinDemoView() {
    }

    @Override
    public void init() {
        textField = new MTextField();
        comboBox = new ComboBox();
        comboBox.setItemCaptionPropertyId("name");
        grid = new MGrid();

        with(textField);
        with(comboBox);
        with(grid);

    }

    @Override
    public String getName() {
        return DemoView.VIEW_NAME;
    }

    @Override
    public void populateComboBoxData(List<ComboBoxData> comboBoxDataList) {

        final BeanItemContainer container = new BeanItemContainer(ComboBoxData.class, comboBoxDataList);
        comboBox.setContainerDataSource(container);

    }
}

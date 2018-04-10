package org.vaadin.demo.view.json;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.addon.json.IndexedJsonContainer;
import org.vaadin.demo.ui.UIUpdater;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.grid.MGrid;
import org.vaadin.viritin.layouts.MHorizontalLayout;

@UIScope
@SpringComponent
public class VaadinJsonView extends MHorizontalLayout implements JsonView {

    private final UIUpdater uiUpdater;
    private MTextField textField;
    private ComboBox comboBox;
    private MGrid grid;

    @Autowired
    public VaadinJsonView(final UIUpdater uiUpdater) {
        this.uiUpdater = uiUpdater;
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

    private void update(){
        this.uiUpdater.update(getUI());
    }

    @Override
    public String getName() {
        return JsonView.VIEW_NAME;
    }

    @Override
    public void populateComboBoxData(String json) {

        final IndexedJsonContainer container = new IndexedJsonContainer(json);
        comboBox.setContainerDataSource(container);


    }

    @Override
    public void updateLoading() {
        update();
    }

    @Override
    public void populateGridData(String json) {
        final IndexedJsonContainer container = new IndexedJsonContainer(json);
        grid.setContainerDataSource(container);
        grid.getColumns().stream().forEach(column -> {
            column.setExpandRatio(1);
        });
        grid.recalculateColumnWidths();
    }
}

package org.vaadin.demo.ui;

import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.UI;

@UIScope
public class UIUpdater {

    private final ProgressBar loadingIndicator;

    public UIUpdater(){
        loadingIndicator = new ProgressBar();
        construct();
    }

    public void construct(){
        this.loadingIndicator.setIndeterminate(true);
        this.loadingIndicator.setVisible(false);
    }

    public void update(UI ui){
        this.loadingIndicator.setVisible(true);
        ui.access(() -> {
            this.loadingIndicator.setVisible(false);
        });
    }
}

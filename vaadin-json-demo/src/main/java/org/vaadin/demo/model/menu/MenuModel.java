package org.vaadin.demo.model.menu;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by huth on 07.07.2017.
 */
public class MenuModel implements java.io.Serializable {

    @Getter @Setter private Long id;
    @Getter @Setter private String label;  // caption of menu to display
    @Getter @Setter private String classString; //full class name of the Component to display ej  "com.sample.Component"
    @Getter @Setter private Long parent; // the idmenu who is the parent
    @Getter @Setter private Integer indice;
    @Getter @Setter private Set<GroupMenu> groupMenus = new HashSet<GroupMenu>(0);
}

package org.vaadin.demo.model.menu;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by huth on 07.07.2017.
 */
public class GroupMenu implements java.io.Serializable {
    @Getter @Setter private Long id;
    @Getter @Setter private MenuModel menuModel;
    @Getter @Setter private Boolean activ; // decides if the menu is active for the group
}

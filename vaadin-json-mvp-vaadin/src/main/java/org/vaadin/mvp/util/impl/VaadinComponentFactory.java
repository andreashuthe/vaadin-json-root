package org.vaadin.mvp.util.impl;

import com.vaadin.data.Property;
import com.vaadin.data.util.converter.Converter;
import com.vaadin.spring.annotation.SpringComponent;
import org.vaadin.mvp.util.IVaadinComponentFactory;
import org.vaadin.viritin.MSize;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MPasswordField;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.layouts.MFormLayout;
import org.vaadin.viritin.layouts.MHorizontalLayout;

/**
 * Created by huth on 09.06.2017.
 */
@SpringComponent
public class VaadinComponentFactory implements IVaadinComponentFactory {

    public MButton createCommitButton() {
        return new MButton();
    }

    public MHorizontalLayout createCommitButtonBar() {
        return new MHorizontalLayout();
    }

    public MFormLayout createFormLayout() {
        return new MFormLayout().withSize(MSize.FULL_SIZE).withMargin(false);
    }

    public MPasswordField createPasswordField(String id, boolean required) {
        final MPasswordField passwordField = new MPasswordField();
        passwordField.withId(id);
        return passwordField;
    }

    public MTextField createTextFieldWithLabel(String id) {
        return createTextFieldWithLabel(id, false);
    }

    public MTextField createTextFieldWithLabel(String id, boolean required) {
        return new MTextField().withId(id).withRequired(required);
    }

    public MTextField createTextFieldWithLabel(String id, Property.ValueChangeListener valueChangeListener) {
        return createTextFieldWithLabel(id, valueChangeListener, false);
    }

    public MTextField createTextFieldWithLabel(String id, Property.ValueChangeListener valueChangeListener, boolean required) {
        return createTextFieldWithLabel(id, valueChangeListener, required, null);
    }

    public MTextField createTextFieldWithLabel(String id, Property.ValueChangeListener valueChangeListener, boolean required, Converter<String, ?> converter) {
        if (converter == null) {
            return createTextFieldWithLabel(id, required).withValueChangeListener(valueChangeListener);
        } else {
            return createTextFieldWithLabel(id, required).withConverter(converter).withValueChangeListener(valueChangeListener);
        }
    }

}

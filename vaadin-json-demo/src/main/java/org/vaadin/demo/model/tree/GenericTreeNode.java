package org.vaadin.demo.model.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenericTreeNode<T> {
    private final List<GenericTreeNode<T>> children;
    private GenericTreeNode<T> parent = null;
    private T data = null;

    public GenericTreeNode() {
        this(null);
    }

    public GenericTreeNode(T data) {
        this(data, null);
    }

    public GenericTreeNode(T data, GenericTreeNode<T> parent) {
        super();
        this.data = data;
        this.parent = parent;
        children = new ArrayList<GenericTreeNode<T>>();
    }

    public void setParent(GenericTreeNode<T> parent) {
        this.parent = parent;
    }

    public List<GenericTreeNode<T>> getChildren() {
        return this.children;
    }

    public int getNumberOfChildren() {
        return getChildren().size();
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        if(this.children.size() == 0)
            return true;
        else
            return false;
    }

    public boolean hasChildren() {
        return (this.children != null && this.children.size() > 0);
    }

    public void addChild(T data) {
        final GenericTreeNode<T> newChild = new GenericTreeNode<T>(data);
        newChild.setParent(this);
        this.children.add(newChild);
    }

    public void addChild(GenericTreeNode<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChildAt(int index, T data) throws IndexOutOfBoundsException {
        final GenericTreeNode<T> newChild = new GenericTreeNode<T>(data);
        newChild.setParent(this);
        this.children.add(index, newChild);
    }

    public void removeChildren() {
        final Iterator<GenericTreeNode<T>> genericTreeNodeIterator = this.children.iterator();
        while (genericTreeNodeIterator.hasNext()) {
            genericTreeNodeIterator.remove();
        }
    }

    public void removeChildAt(int index) throws IndexOutOfBoundsException {
        children.remove(index);
    }

    public GenericTreeNode<T> getChildAt(int index) throws IndexOutOfBoundsException {
        return children.get(index);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return getData().toString();
    }

    public boolean equals(GenericTreeNode<T> node) {
        return node.getData().equals(getData());
    }

    public int hashCode() {
        return getData().hashCode();
    }

    public GenericTreeNode<T> getParent() {
        return parent;
    }

    public String toStringVerbose() {
        final StringBuilder sb = new StringBuilder(getData().toString() + ":[");

        for (final GenericTreeNode<T> node : getChildren()) {
            sb.append(node.getData().toString()).append(", ");
        }

        //Pattern.DOTALL causes ^ and $ to match. Otherwise it won't. It's retarded.
        final Pattern pattern = Pattern.compile(", $", Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(sb.toString());

        String stringRepresentation = matcher.replaceFirst("");
        stringRepresentation += "]";

        return stringRepresentation;
    }
}

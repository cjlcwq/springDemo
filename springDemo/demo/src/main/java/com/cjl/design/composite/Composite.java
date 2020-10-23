package com.cjl.design.composite;

import java.util.ArrayList;

public class Composite implements Component {
    private ArrayList<Component> children = new ArrayList<Component>();
    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return children.get(i);
    }

    @Override
    public void operation() {
        for (Object child : children) {
            ((Component)child).operation();
        }
    }
}

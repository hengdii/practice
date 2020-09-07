package com.jiaty.demo.design.patterns.decorator;

/**
 * @program: practice
 * @description:
 * @author: Jiaty
 * @create: 2020-09-07 16:27
 **/

public abstract class Decorator extends Component {

    protected Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    void operation() {
        if (component != null) {
            component.operation();
        }
    }
}
package com.jiaty.demo.effective.createAndDestroyObjects.eliminateOutdatedObjectReferences;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @program: practice
 * @description: "内存泄漏"
 * @author: jiaty
 * @create: 2019-12-20 15:06
 **/

public class Stack {

    private Object[] elements;

    private int size = 0;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 第一次的写法，在被弹出之后。需要对对象清除过期引用。否则gc不仅不会处理这个对象，而且也不会处理被这个对象所引用的其他对象。
     * <p>
     * 只要类是自己管理内存，就需要注意内存泄漏问题。一旦元素被释放掉，则该元素中包含的任何对象的引用都应该被清空
     */
    public Object popOne() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    /**
     * 修订版本，清空过期引用。  如果他们以后又被错误的引用，程序就会立即抛出NullPointerException异常。而不是悄悄的错误运行下去。尽快的检测出程序中的错误总是有益的
     * <p>
     * 清除过期引用最好的方法就是让包含该引用的变量，结束生命周期。在最紧凑的作用域范围定义每一个变量，这种情形就会自然而然的发生
     */
    public Object popTwo() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

}
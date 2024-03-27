package main.etc.generic;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackEx {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_SIZE = 16;

    public StackEx() {
        elements = new Object[DEFAULT_SIZE];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object e = elements[--size];
        elements[size] = null;
        return e;
    }

    /*
    * 원소를 위한 공간을 적어도 하나 이상 확보한다.
    * 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
    * */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, size * 2 + 1);
        }
    }
}

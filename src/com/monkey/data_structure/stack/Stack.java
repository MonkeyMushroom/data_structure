package com.monkey.data_structure.stack;

/**
 * First In Last Out
 */
public interface Stack<E> {

    /**
     * 获取实际大小
     */
    int getSize();

    /**
     * 是否为空
     */
    boolean isEmpty();

    /**
     * 进栈
     */
    void push(E e);

    /**
     * 出栈
     */
    E pop();

    /**
     * 瞧一眼栈顶元素
     */
    E peek();
}

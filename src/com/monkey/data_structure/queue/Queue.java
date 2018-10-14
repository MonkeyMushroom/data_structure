package com.monkey.data_structure.queue;

/**
 * First In First Out
 */
public interface Queue<E> {

    /**
     * 获取实际大小
     */
    int getSize();

    /**
     * 是否为空
     */
    boolean isEmpty();

    /**
     * 入队
     */
    void enqueue(E e);

    /**
     * 出队
     */
    E dequeue();

    /**
     * 瞧一眼队首元素
     */
    E getFront();
}

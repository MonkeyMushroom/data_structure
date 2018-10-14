package com.monkey.data_structure.heap;

import com.monkey.data_structure.queue.Queue;

/**
 * 基于最大堆的优先队列
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    /**
     * 入队
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    /**
     * 出队根据优先级规则，返回最大堆中的最大值
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    /**
     * 队首元素，即最大堆中的最大值
     */
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}

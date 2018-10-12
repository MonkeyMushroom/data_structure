package com.monkey.heap;

import com.monkey.array.Array;

import java.util.LinkedList;

/**
 * 二叉堆，是一棵完全二叉树，把元素顺序排列成树的形状
 * 并且某个节点的值总是不大于其父节点的值，称为最大堆（相应的也可以定义最小堆），根节点为最大值（最小值）
 * 可以将二叉堆按顺序用数组存储，节点与索引i的关系如下：
 * parent(i) = (i - 1) / 2
 * left child (i) = 2 * i + 1
 * right child (i) = 2 * i + 2
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 将任意数组整理成堆的形状 - Heapify
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        //从最后一个叶子结点的父节点开始，循环下沉 O(n)
        for (int i = parent(data.getSize() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * 添加元素 O(logn)
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 当添加的元素不符合最大堆的规则（即该元素比其父节点大）时，进行上浮操作
     * 循环上浮，直到成为根节点（k = 0），或者该元素比其父节点小时结束
     *
     * @param k 添加的元素的索引
     */
    private void siftUp(int k) { //O(logn)
        //该元素父节点的值小于该元素的值
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));//该元素与其父节点交换位置
            k = parent(k);//该元素索引改为其父节点的索引
        }
    }

    /**
     * 找到堆中最大元素
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can't findMax when heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大元素 O(logn)
     */
    public E extractMax() {
        E e = findMax();
        data.swap(0, data.getSize() - 1);//末尾元素与根节点（最大元素）交换位置
        data.removeLast();//删除现在的末尾元素，也就是之前的最大元素
        siftDown(0);//此时使用下沉操作判断根节点是否不符合最大堆的特性
        return e;
    }

    /**
     * 下沉操作，该节点小于其左右子节点的大节点，交换位置
     *
     * @param k 根节点索引
     */
    private void siftDown(int k) { //O(logn)
        while (leftChild(k) < data.getSize()) {//左子节点没越界
            int j = leftChild(k);
            //右子节点没越界，并且比左子节点大
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);//data[j] 是 leftChild 和 rightChild 中的最大值
            }
            if (data.get(k).compareTo(data.get(j)) > 0) {
                break;//该节点比大子节点还要大，就无需下沉
            }
            data.swap(k, j);//交换位置
            k = j;
        }
    }

    /**
     * 取出堆中的最大元素，并且替换成元素e
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}

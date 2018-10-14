package com.monkey.data_structure.set;

import com.monkey.data_structure.linkedlist.LinkedList;

/**
 * 基于链表的集合
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {// O(n)
        if (!list.contains(e)) {//不能添加重复的元素 O(n)
            list.addFirst(e);// O(1)
        }
    }

    @Override
    public void remove(E e) {// O(n)
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {// O(n)
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

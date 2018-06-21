package com.monkey.set;

import com.monkey.binarysearchtree.BinarySearchTree;

/**
 * 基于二分搜索树的集合
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> bst;

    public BSTSet() {
        bst = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {// O(logn)
        bst.add(e);
    }

    @Override
    public void remove(E e) {// O(logn)
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {// O(logn)
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}

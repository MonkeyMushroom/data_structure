package com.monkey.binarysearchtree;

/**
 * 二分搜索树
 * 节点左子树都要比该节点小，节点右子树都要比该节点大
 * 不包含重复元素，如果想包含重复元素，只需要定义：左子树小于等于节点，或者右子树大于等于节点
 */
public class BinarySearchTree<E extends Comparable<E>> {

    public class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 以node为根的二分搜索树中插入元素e，递归算法
     * 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }
}

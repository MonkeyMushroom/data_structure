package com.monkey.segmenttree;

/**
 * 线段树（区间树），用于区间内值的查询、更新
 * *           [0,5]
 * *        /        \
 * *     [0,2]      [3,5]
 * *     /  \       /  \
 * *  [0,1]  2   [3,4]  5
 * *  /  \       /  \
 * * 0   1      3   4
 * 不是完全二叉树（节点顺序排列），但是平衡二叉树（子节点深度差不超过1），完全二叉树也是平衡二叉树
 * 如果区间有n个元素，使用数组需要4n个节点，不考虑添加元素，即区间固定，使用4n的静态控间即可
 * 数组的值由业务需求决定，可以是一个区间内元素之和，也可以是其左子节点和右子节点的最大值最小值，等等
 */
public class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在treeIndex的位置创建表示区间[l,r]的线段树
     *
     * @param treeIndex
     * @param l         左区间
     * @param r         右区间
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {//叶子节点
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        //treeIndex节点的值，由具体业务需求决定
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("out if index");
        }
        return data[index];
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
     * 返回区间[queryL,r]的值
     *
     * @param queryL 左区间
     * @param queryR 右区间
     * @return e
     */
    public E query(int queryL, int queryR) {// O(logn)
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("out of index");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 返回以treeIndex为根的线段树中[l,r]的范围里，搜索区间[queryL,queryR]的值
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryL >= mid + 1) {//跟左子树没关系，只查找右子树
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {//跟右子树没关系，只查找左子树
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }
        //有一段在左子树，有一段在右子树，分开查找
        E leftRes = query(leftTreeIndex, l, mid, queryL, mid);
        E rightRes = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftRes, rightRes);
    }

    public void set(int index, E e) {// O(logn)
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("out of index");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    /**
     * 在以treeIndex为根的线段树中更新index的值为e
     */
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid + 1) {
            set(rightTreeIndex, mid + 1, r, index, e);
        } else {
            set(leftTreeIndex, l, mid, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < tree.length; i++) {
            sb.append(tree[i]);
            if (i != tree.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

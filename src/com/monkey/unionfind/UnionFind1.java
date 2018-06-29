package com.monkey.unionfind;

public class UnionFind1 implements UF {

    private int[] parent;

    public UnionFind1(int size) {
        parent = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    /**
     * 查看元素p和元素q是否属于同一集合
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合 O(h)
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = parent[qRoot];
    }

    /**
     * 查找元素p所对应的集合编号 O(h)
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("index out of bounds");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}

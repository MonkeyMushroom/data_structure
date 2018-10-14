package com.monkey.data_structure.segmenttree;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, (a, b) -> a + b);
        System.out.println(segmentTree.toString());
        System.out.println(segmentTree.query(0, 5));
    }
}

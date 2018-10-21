package com.monkey.algorithms.search;

import java.util.Random;

/**
 * 二分法查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = arr[new Random().nextInt(arr.length)];
        int index = find(arr, target);
        System.out.println(target + " " + index);
    }

    /**
     * 在有序数组arr中,查找target
     * 如果找到target,返回相应的索引index
     * 如果没有找到target,返回-1
     */
    private static int find(int[] arr, int target) {
        return find(arr, target, 0, arr.length - 1);
    }

    private static int find(int[] arr, int target, int l, int r) {
        if (l > r) return -1;
        // int mid = (l+r)/2;
        // 防止极端情况下的整形溢出，使用下面的逻辑求出mid
        int mid = l + (r - l) / 2;
        if (target > arr[mid]) {
            return find(arr, target, mid + 1, r);
        } else if (target < arr[mid]) {
            return find(arr, target, l, mid - 1);
        } else {
            return mid;
        }
    }
}

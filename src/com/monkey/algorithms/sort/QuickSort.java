package com.monkey.algorithms.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 6, 2, 3, 1, 5, 7, 4};
        quickSort(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    // 对arr[l...r]部分进行partition分区操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                swap(arr, j, i);
            }
        }

        swap(arr, l, j);

        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

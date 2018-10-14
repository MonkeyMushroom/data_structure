package com.monkey.algorithms.sort;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 6, 2, 3, 1, 5, 7, 4};
        selectSort(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    private static void selectSort(int[] arr) {// O(n^2)
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;// 找到[i, arr.length)区间里的最小值的索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //将最小值和i位数值交换
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}

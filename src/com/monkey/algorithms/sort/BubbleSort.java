package com.monkey.algorithms.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 6, 2, 3, 1, 5, 7, 4};
        bubbleSort(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;// 提前退出的标志位
            // 两两比较，最后一位不需要比较，之前i次排好的不需要比较
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {// 交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;// 表示有数据交换
                }
            }
            if (!flag) break;// 没有数据交换，提前退出
        }
    }
}

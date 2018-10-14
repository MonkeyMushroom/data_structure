package com.monkey.algorithms.sort;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 6, 2, 3, 1, 5, 7, 4};
        insertionSort(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {//从第1位开始
            //第1种写法
//            for (int j = i; j > 0; j--) {//往前比较
//                if (arr[j] < arr[j - 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j - 1];
//                    arr[j - 1] = temp;
//                } else {
//                    break;
//                }
//            }

            //第2种写法
//            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
//                int temp = arr[j];
//                arr[j] = arr[j - 1];
//                arr[j - 1] = temp;
//            }

            //第3种写法
            int e = arr[i];
            int j = i;
            for (; j > 0 && e < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
}

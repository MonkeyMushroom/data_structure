package com.monkey.recursion;

public class Sum {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(sum(arr, 0));
    }

    private static int sum(int[] arr, int i) {
        if (i == arr.length) {
            return 0;
        }
        return arr[i] + sum(arr, i + 1);
    }
}

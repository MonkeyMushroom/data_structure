package com.monkey;

public class Main {

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        arr.add(1, 100);
        arr.addFirst(-1);

        System.out.println(arr);
    }
}

package com.monkey.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList.toString());
        for (int i = 0; i < 3; i++) {
            linkedList.removeFirst();
        }
        System.out.println(linkedList.toString());
    }
}

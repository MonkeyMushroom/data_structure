package com.monkey;

public class Array {

    private int[] data;
    private int size;//实际大小

    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;//占用空间
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int value) {
        add(0, value);
    }

    public void addLast(int value) {
        add(size, value);
    }

    public void add(int index, int value) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed,array is full.");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,require index >=0 and index <= size.");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[size] = value;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

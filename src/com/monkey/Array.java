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

    /**
     * 插入元素
     *
     * @param index 指定位置
     * @param value
     */
    public void add(int index, int value) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed,array is full.");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,require index >=0 and index <= size.");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];//index之后的元素向后移一位
        }
        data[index] = value;
        size++;
    }

    /**
     * 删除元素，并返回删除的元素
     *
     * @param index 指定位置
     * @return
     */
    public int remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed,require index >=0 and index <= size.");
        }
        int value = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return value;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,index is illegal.");
        }
        return data[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,index is illegal.");
        }
        data[index] = value;
    }

    /**
     * 查找数组中是否有元素value
     *
     * @param value
     * @return
     */
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素value所在的索引，不存在则返回-1
     *
     * @param value
     * @return
     */
    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
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

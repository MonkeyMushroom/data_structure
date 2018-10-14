package com.monkey.data_structure.array;

/**
 * 增删改查，支持泛型，动态扩容缩容
 */
public class Array<E> {

    private E[] data;
    private int size;//实际大小

    public Array(int capacity) {
        data = (E[]) new Object[capacity];//泛型的初始化
        size = 0;
    }

    public Array() {
        this(10);
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
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

    public void addFirst(E e) {//  O(n)
        add(0, e);
    }

    public void addLast(E e) {//  O(1)
        add(size, e);
    }

    /**
     * 插入元素  O(n/2) = O(n)
     *
     * @param index 指定位置
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,require index >=0 and index <= size.");
        }
        if (size == data.length) {//元素加满了，扩容
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];//index之后的元素向后移一位
        }
        data[index] = e;
        size++;
    }

    /**
     * 删除元素，并返回删除的元素  O(n/2) = O(n)
     *
     * @param index 指定位置
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed,require index >=0 and index <= size.");
        }
        E e = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];//向前一位赋值
        }
        size--;
        data[size] = null;//loitering objects 闲散游荡的对象，可以置空回收，但不代表内存泄漏memory leak
        if (size == data.length / 4 && data.length / 2 != 0) {//元素个数到总容量1/4时，缩小一半空间，防止复杂度震荡
            resize(data.length / 2);
        }
        return e;
    }

    public E removeFirst() {//  O(n)
        return remove(0);
    }

    public E removeLast() {//  O(1)
        return remove(size - 1);
    }

    /**
     * 动态调整空间大小  O(n)
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public E get(int index) {//  O(1)
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,index is illegal.");
        }
        return data[index];
    }

    public void set(int index, E e) {//  O(1)
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e  O(n)
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，不存在则返回-1  O(n)
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 交换位置
     */
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("index out of bounds");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
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

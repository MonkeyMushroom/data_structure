package com.monkey.linkedlist;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;//虚拟头节点
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index位置添加新的元素e
     */
    public void add(int index, E e) {// O(n)
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//        Node node = new Node(e);//要添加的节点
//        node.next = prev.next;//添加的节点的next指向prev节点的next        prev   -->   prev.next
//        prev.next = node;//prev节点的next指向要添加的节点                   |-->  node  --↑
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {// O(1)
        add(0, e);
    }

    public void addLast(E e) {// O(n)
        add(size, e);
    }

    public E get(int index) {// O(n)
        if (index < 0 && index >= size) {
            throw new IllegalArgumentException("Get failed,illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {// O(1)
        return get(0);
    }

    public E getLast() {// O(n)
        return get(size - 1);
    }

    public void set(int index, E e) {// O(n)
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed,illegal index.");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {// O(n)
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {// O(n)
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed,illegal index.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node del = prev.next;
        prev.next = del.next;
        del.next = null;
        size--;
        return del.e;
    }

    public E removeFirst() {// O(1)
        return remove(0);
    }

    public E removeLast() {// O(n)
        return remove(size - 1);
    }

    // 从链表中删除元素e
    public void removeElement(E e) {// O(n)
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e))
                break;
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur).append("->");
        res.append("NULL");
        return res.toString();
    }
}

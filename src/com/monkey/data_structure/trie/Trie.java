package com.monkey.data_structure.trie;

import java.util.TreeMap;

/**
 * 字典树（前缀树），多叉树
 * 查询每个条目的时间复杂度和字典中一共多少条目无关，和条目字符串长度有关
 * *        root
 * *      /  |  \
 * *    c    d   p
 * *    |   / \  |
 * *    a  o  e  a
 * *    |  |  |  |
 * *    t  g  e  n
 * *          |
 * *          r
 * 优点：时间复杂度O(H)，如果字典只查小写字母，那么最高就是O(log26)
 * 缺点：由于每个节点只代表一个字母，那么每个节点都会有若干个指针，消耗的空间比较大
 */
public class Trie {

    private class Node {
        public boolean isWord;//是否为单词的结尾
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 向Trie中添加一个新的单词word
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询word是否在Trie中
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 查询在Trie中是否有单词以prefix为前缀
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}

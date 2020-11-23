package ru.stk.hw08;

import java.util.LinkedList;

public class HashTableLink<K, V> implements HashTable<K, V> {


    private final LinkedList<HashTableLink.Node<K, V>>[] data;
    private int size;
    private final int maxSize;

    public HashTableLink(int maxSize) {
        this.maxSize = maxSize;
        this.data = new LinkedList[maxSize];
        for (int i = 0; i < maxSize; i++) {
            data[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hash(key);

        if (size == maxSize) {
            return false;
        }

        data[index].add(new Node<>(key, value));
        size++;
        return true;
    }

    private int hash(K key) {
        return key.hashCode() % data.length;
    }

    private int indexOf(K key) {
        return hash(key);
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        for (Node<K, V> n : data[index]) {
            if (n.getKey().equals(key)) {return n.getValue();
            }
        }
        return null;
    }



    @Override
    public V remove(K key) {
        int index = indexOf(key);
        V val;

        for (Node<K, V> n : data[index]) {
            if (n.getKey().equals(key)) {
                val = n.getValue();
                data[index].remove(n);
                size--;
                return val;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return maxSize;
    }

    @Override
    public boolean isEmpty() {
        return maxSize == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]);
        }
        System.out.println("----------");
    }

    static class Node<K, V> implements HashTable.Entry<K, V> {

        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


}

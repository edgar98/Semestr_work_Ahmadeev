package ru.itis.set;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class DictionarySet implements Set {
    private static class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int count;


    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node node = head;
        while (node.next != null) {
            if (o.equals(node.value)) return true;
            node = node.next;
        }
        return false;
    }

    private class LinkedListIterator implements Iterator {
        // указывает на текущий узел
        private Node currentNode;

        public LinkedListIterator() {

            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {
            if (currentNode == tail) return true;
            return currentNode != null;
        }

        @Override
        public Object next() {
            Object result = currentNode.value;
            currentNode = currentNode.next;
            return result;
        }
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}

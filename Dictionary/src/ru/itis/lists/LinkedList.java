package ru.itis.lists;

/**
 * 15.02.2018
 * LinkedList
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

import java.util.Iterator;

/**
 * Реализация списка на основе узлов (связного списка)
 */
public class LinkedList<T> implements List<T> {

    public static <E extends Comparable<E>> LinkedList merge(LinkedList<E> a, LinkedList<E> b) {
        Iterator<E> iteratorA = a.iterator();
        Iterator<E> iteratorB = b.iterator();
        LinkedList<E> merged = new LinkedList<>();
//        if (iteratorA.hasNext()) {
//            if (iteratorB.hasNext()) {
//                E currentPair1 = iteratorA.next();
//                E currentPair2 = iteratorA.next();
//                if (currentPair1.compareTo(currentPair2) < 0) {
//                    merged.add(currentPair1);
//                    merged.add(currentPair2);
//                    iteratorA.next();
//                    iteratorB.next();
//                } else {
//                    merged.add(currentPair2);
//                    merged.add(currentPair1);
//                    iteratorB.next();
//                    iteratorA.next();
//                }
//            } else  {
//                while (iteratorA.hasNext()) {
//                    merged.add(iteratorA.next());
//                    iteratorA.hasNext();
//                }
//            }
//        }


        E currentPair1 = iteratorA.next();
        E currentPair2 = iteratorB.next();

        while (iteratorA.hasNext() && iteratorB.hasNext()) {
            if (currentPair1.compareTo(currentPair2) < 0) {
                merged.add(currentPair1);
                currentPair1 = iteratorA.next();
            } else {
                merged.add(currentPair2);
                currentPair2 = iteratorB.next();
            }
        }
            while (iteratorA.hasNext()) {
                if (currentPair2.compareTo(currentPair1) < 0) {
                    merged.add(currentPair2);
                    currentPair2 = null;
                }
                merged.add(currentPair1);
                currentPair1 = iteratorB.next();
            }
            while (iteratorB.hasNext()) {
                if (currentPair1.compareTo(currentPair2) < 0) {
                    merged.add(currentPair1);
                    currentPair1 = null;
                }
                merged.add(currentPair2);
                currentPair2 = iteratorB.next();
            }
            if (currentPair1 != null) merged.add(currentPair1);
            if (currentPair2 != null) merged.add(currentPair2);

        return merged;
    }

    private class LinkedListIterator implements Iterator<T> {
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
        public T next() {
            T result = currentNode.value;
            currentNode = currentNode.next;
            return result;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    protected class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }

    protected Node head;
    private Node tail;

    private int count;

    public LinkedList() {
        this.count = 0;
    }

    public int indexOf(T element) {
        int index = 0;
        Node currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.value.equals(element)) return index;
            currentNode = currentNode.next;
            index++;
        }
        if (currentNode.value.equals(element)) return index;
        return -1;
    }


    @Override
    public T get(int index) {
        if (index >= count) {
            throw new IllegalArgumentException();
        }
        if (index == -1) return null;
        Node current = this.head;
        int i = 0;

        while (i < index) {
            current = current.next;
            i++;
        }

        return current.value;
    }

    // TODO: реализовать
    @Override
    public void addToBegin(T element) {
        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        count++;
    }

    @Override
    public void add(T element) {
        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    @Override
    public void remove(T element) {
        removeByIndex(this.indexOf(element));
    }

    public void removeByIndex(int index) {
        if (index == -1) return;
        int imaginaryIndex = 0;
        Node currentNode = head;
        if (index == 0) {
            head = head.next;
            count--;
        } else {
            while (imaginaryIndex + 1 != index) {
                currentNode = currentNode.next;
                imaginaryIndex++;
            }
            if (currentNode.next == tail) tail = head;
            currentNode.next = currentNode.next.next;
            count--;
        }
    }

    @Override
    public boolean contains(T element) {
        Node node = head;
        while (node.next != null) {
            if (element.equals(node.value)) return true;
            node = node.next;
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    public void reverseList() {
        reverseNodes(head);
        Node t = head;
        head = tail;
        tail = t;
        tail.next = null;
    }

    private void reverseNodes(Node node) {
        if (node != tail) reverseNodes(node.next);
        if (node.next != null) {
            node.next.next = node;
        } else return;
    }
}

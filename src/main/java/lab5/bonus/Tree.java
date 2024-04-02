package lab5.bonus;

import java.util.HashSet;
import java.util.List;

public class Tree<T extends Comparable<T>> {
    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node<T> root;
    private int size;

    public Tree() {
        root = null;
        size = 0;
    }

    public void addValue(T value) {
        root = add(root, value);
        size++;
    }

    private Node<T> add(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        if (value.compareTo(node.data) < 0) {
            node.left = add(node.left, value);
        } else if (value.compareTo(node.data) > 0) {
            node.right = add(node.right, value);
        }

        return node;
    }

    public void addAll(List<T> values) {
        for (T value : values) {
            addValue(value);
        }
    }

    public HashSet<T> getValues(T inf, T sup) {
        HashSet<T> result = new HashSet<>();
        getValues(root, inf, sup, result);
        return result;
    }

    private void getValues(Node<T> node, T inf, T sup, HashSet<T> result) {
        if (node == null) {
            return;
        }

        if (node.data.compareTo(inf) >= 0 && node.data.compareTo(sup) <= 0) {
            result.add(node.data);
        }

        if (node.data.compareTo(inf) > 0) {
            getValues(node.left, inf, sup, result);
        }

        if (node.data.compareTo(sup) < 0) {
            getValues(node.right, inf, sup, result);
        }

        if (node.data.equals(inf)) {
            getValues(node.right, inf, sup, result);
        }

        if (node.data.equals(sup)) {
            getValues(node.left, inf, sup, result);
        }
    }



    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

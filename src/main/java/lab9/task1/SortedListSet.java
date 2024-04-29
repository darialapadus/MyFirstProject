package lab9.task1;

import java.util.*;

public class SortedListSet<T extends Comparable<T>> extends LinkedList<T> implements SortedSet<T> {
    private Comparator<? super T> comparator;

    public SortedListSet() {
        this(null);
    }

    public SortedListSet(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public SortedListSet(Comparator<? super T> comparator, List<T> sortedList) {
        this(comparator);
        addAll(sortedList);
    }

    @Override
    public boolean add(T o) {
        int index = findInsertionIndex(o);
        if (index == size() || !get(index).equals(o)) {
            add(index, o);
            return true;
        }
        return false;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return getFirst();
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return getLast();
    }

    @Override
    public SortedSet<T> subSet(T from, T to) {
        int fromIndex = findInsertionIndex(from);
        int toIndex = findInsertionIndex(to);
        return new SortedListSet<>(comparator, subList(fromIndex, toIndex));
    }

    @Override
    public SortedSet<T> headSet(T to) {
        int toIndex = findInsertionIndex(to);
        return new SortedListSet<>(comparator, subList(0, toIndex));
    }

    @Override
    public SortedSet<T> tailSet(T from) {
        int fromIndex = findInsertionIndex(from);
        return new SortedListSet<>(comparator, subList(fromIndex, size()));
    }

    @Override
    public Comparator<? super T> comparator() {
        return comparator;
    }

    private int findInsertionIndex(T element) {
        Comparator<? super T> comp = comparator != null ? comparator : Comparator.naturalOrder();
        int index = 0;
        for (T e : this) {
            if (comp.compare(element, e) <= 0) {
                return index;
            }
            index++;
        }
        return index;
    }
}






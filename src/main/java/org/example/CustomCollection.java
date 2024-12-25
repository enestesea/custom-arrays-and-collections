package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class CustomCollection {

    // Порог для использования indexedBinarySearch

    private static final int BINARYSEARCH_THRESHOLD   = 5000;

    // Binary search for List without Comparator

    public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key) {
        if (list instanceof RandomAccess || list.size()<BINARYSEARCH_THRESHOLD)
            return indexedBinarySearch(list, key);
        else
            return iteratorBinarySearch(list, key);
    }

    // Binary search for List with Comparator

    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
        if (c==null)
            return binarySearch((List<? extends Comparable<? super T>>) list, key);

        if (list instanceof RandomAccess || list.size()<BINARYSEARCH_THRESHOLD)
            return indexedBinarySearch(list, key, c);
        else
            return iteratorBinarySearch(list, key, c);
    }

    // Индексированный binary search

    private static <T> int indexedBinarySearch(List<? extends Comparable<? super T>> list, T key) {
        int low = 0;
        int high = list.size()-1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable<? super T> midVal = list.get(mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key найден
        }
        return -(low + 1);  // key не найден
    }

    //  Binary search через итератор

    private static <T> int iteratorBinarySearch(List<? extends Comparable<? super T>> list, T key)
    {
        int low = 0;
        int high = list.size()-1;
        ListIterator<? extends Comparable<? super T>> i = list.listIterator();

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable<? super T> midVal = get(i, mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key найден
        }
        return -(low + 1);  // key не найден
    }

    // Метод для получения элемента по индексу через итератор

    private static <T> T get(ListIterator<? extends T> i, int index) {
        T obj;
        int pos = i.nextIndex();
        if (pos <= index) {
            do {
                obj = i.next();
            } while (pos++ < index);
        } else {
            do {
                obj = i.previous();
            } while (--pos > index);
        }
        return obj;
    }

    // Индексированный binary search с Comparator

    private static <T> int indexedBinarySearch(List<? extends T> l, T key, Comparator<? super T> c) {
        int low = 0;
        int high = l.size()-1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = l.get(mid);
            int cmp = c.compare(midVal, key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key найден
        }
        return -(low + 1);  // key не найден
    }

    //  Binary search через итератор с  Comparator
    private static <T> int iteratorBinarySearch(List<? extends T> l, T key, Comparator<? super T> c) {
        int low = 0;
        int high = l.size()-1;
        ListIterator<? extends T> i = l.listIterator();

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = get(i, mid);
            int cmp = c.compare(midVal, key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key найден
        }
        return -(low + 1);  // key не найден
    }
}
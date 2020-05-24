package com.douye.sort;

public class InsertionSort02<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            T v = array[index];
            for (int j = index; j > 0; j--) {
                if (cmp(j,j-1) < 0) {
                    array[j] = array[j-1];
                }
                index--;
            }
            array[index] = v;
        }
    }
}

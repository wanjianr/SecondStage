package com.douye.sort;

public class InsertionSort01<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        for (int i = 1; i < array.length; i++) {
            int index = i;
            while (index > 0 && cmp(index,index-1) <= 0){
                swap(index,index-1);
                index--;
            }
        }
    }
}

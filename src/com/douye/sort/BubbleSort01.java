package com.douye.sort;

public class BubbleSort01<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        for (int end = array.length-1; end > 0; end--) {
            int searchState = 1;
            for (int j = 1; j <= end; j++) {
                if (cmp(array[j-1],array[j]) > 0) {
                    swap(j-1,j);
                    searchState = j;
                }
            }
            end = searchState;
        }
    }
}

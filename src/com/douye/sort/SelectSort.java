package com.douye.sort;

public class SelectSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        Integer tmp = 0;
        int index = 0;
        for (int j = array.length-1; j > 0 ; j--) {
            index = 0;
            for (int i = 1; i <= j; i++) {
                if (cmp(array[i],array[index]) >= 0) {
                    index = i;
                }
            }
            // 将找到的最大值与最后一个元素进行交换
            swap(index,j);
        }
    }
}

package com.douye.sort;

public class InsertoinSort03<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            T v = array[index];
            // 获取插入坐标
            // 使用遍历法
//            while (index > 0 && cmp(v,array[index-1]) < 0) {
//                index--;
//            }
            // 使用二分法
            index = search(index);
            for (int j = i; j > index; j--) {
                if (cmp(j,j-1) < 0) {
                    array[j] = array[j-1];
                }
            }
            array[index] = v;
        }
    }

    private int search(int index) {
        int begin = 0;
        int end = index;
        int mid = 0;
        while (begin < end) {
            mid = (begin + end) >> 1;
            if (cmp(index,mid) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}

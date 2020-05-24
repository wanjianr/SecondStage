package com.douye.sort;

public class 基数排序 {
    static void radixSort(int[] array) {
        // 1. 找出最大值
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i])
                max = array[i];
        }

        int[] counts = new int[10];
        int[] output = new int[array.length];

        // 2.对各个基数分别进行计数排序
        for (int divider = 1; divider <= max; divider*=10) {
            for (int i = 0; i < counts.length; i++) {
                counts[i] = 0;
            }
            // 进行计数排序
            // 2.1 对array中的数进行计数
            for (int i = 0; i < array.length; i++) {
                counts[array[i] / divider % 10]++;
            }
            // 2.2 进行求和操作
            for (int i = 1; i < counts.length; i++) {
                counts[i] += counts[i-1];
            }
            // 2.3 根据counts中存的数值得到array[i]在排序output中的的下标
            for (int i = array.length-1; i >= 0 ; i--) {
                output[--counts[array[i] / divider % 10]] = array[i];
            }
            // 2.4 将排好序的数组还原到原来的数组中，继续下一轮排序
            for (int i = 0; i < array.length; i++) {
                array[i] = output[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {232,321,223,132,221,321,2434,164,432,332,232};
        radixSort(array);
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}

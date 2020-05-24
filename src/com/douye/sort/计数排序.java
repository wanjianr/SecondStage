package com.douye.sort;

public class 计数排序 {
    static void CountingSort01(int[] array) {
        // 1.找出数组中的最大值并建一个计数数组
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        // 数组初始化时，每个元素默认为0
        int[] counts = new int[max + 1];

        // 2.对原数组中的数进行计数
        for (int i = 0; i < array.length; i++) {
            // 计数数组的索引 = array中出现的数字
            counts[array[i]]++;
        }
//        System.out.println("最大值："+max);
//        int s = 0;
//        for (int count : counts) {
//            System.out.print(s++ +"_<"+count+"> ");
//        }

        // 3.从计数数组中读出数据,存入原数组
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                array[index++] = i;
            }
        }
    }

    static void CountingSort02(int[] array) {
        // 1.找出数组中的最大值并建一个计数数组
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        // 数组初始化时，每个元素默认为0
        int[] counts = new int[max - min + 1];

        // 2.对原数组中的数进行计数
        for (int i = 0; i < array.length; i++) {
            // 计数数组的索引 = array中出现的数字
            counts[array[i] - min]++;
        }
        System.out.println("最大值："+max);
        System.out.println("最小值："+min);

        // 3.从计数数组中读出数据,存入原数组
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                array[index++] = i + min;
            }
        }
    }

    // 可以对负整数排序
    static void CountingSort03(int[] array) {
        // 1.找出数组中的最大值并建一个计数数组
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        // 数组初始化时，每个元素默认为0
        int[] counts = new int[max - min + 1];

        // 2.对原数组中的数进行计数
        for (int i = 0; i < array.length; i++) {
            // 计数数组的索引 = array中出现的数字
            counts[array[i] - min]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i-1];
        }

        // 3.从计数数组中读出数据,存入原数组
        int[] output = new int[array.length];
        for (int i = array.length-1; i >= 0 ; i--) {
            counts[array[i]-min] -= 1; // 确定数字array[i]在有序数组中的下标
            output[counts[array[i]-min]] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {3,2,1,4,3,2,5,4,3,10,2,2,1,1,3,2,3};
        int[] array1 = {30,21,32,23,24,23,25,23,26,29};
        CountingSort03(array);
        System.out.println();
        for (Integer integer : array) {
            System.out.print(integer+" ");
        }
    }
}

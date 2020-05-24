package com.douye.sort;

import com.douye.tools.Integers;
import com.douye.tools.Times;

public class 选择排序 {
    static void selectSort00(Integer[] arrays) {
        Integer max = null;
        Integer tmp = 0;
        int index = 0;
        for (int j = arrays.length-1; j > 0 ; j--) {
            max = arrays[0];
            index = 0;
            for (int i = 1; i <= j; i++) {
                if (arrays[i] >= max) {  //这里加等号，保证排序的稳定性
                    max = arrays[i];
                    index = i;
                }
            }
            // 将找到的最大值与最后一个元素进行交换
            tmp = arrays[j];
            arrays[j] = arrays[index];
            arrays[index] = tmp;
        }
    }

    static void selectSort01(Integer[] arrays) {
        Integer tmp = 0;
        int index = 0;
        for (int j = arrays.length-1; j > 0 ; j--) {
            index = 0;
            for (int i = 1; i <= j; i++) {
                if (arrays[i] >= arrays[index]) {  //这里加等号，保证排序的稳定性
                    index = i;
                }
            }
            // 将找到的最大值与最后一个元素进行交换
            tmp = arrays[j];
            arrays[j] = arrays[index];
            arrays[index] = tmp;
        }
    }

    static void bubbleSort(Integer[] arrays) {
        int tmp = 0;
        for (int end = arrays.length-1; end > 0; end--) {
            int searchState = 1;
            for (int j = 1; j <= end; j++) {
                if (arrays[j-1] < arrays[j]) {
                    tmp = arrays[j-1];
                    arrays[j-1] = arrays[j];
                    arrays[j] = tmp;
                    searchState = j;
                }
            }
            end = searchState;
        }
    }

    public static void main(String[] args) {
        Integer[] arrays = Integers.random(50,1,100);
        Integer[] copy = Integers.copy(arrays);

        Times.test("selectSort00",() ->{
            selectSort01(arrays);
        });
        for (Integer array : arrays) {
            System.out.print(array+" ");
        }
        Times.test("bubbleSort",() ->{
            bubbleSort(copy);
        });
    }
}

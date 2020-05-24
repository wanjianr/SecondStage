package com.douye.sort;

import com.douye.tools.Integers;
import com.douye.tools.Times;

import java.util.ArrayList;

public class 冒泡排序 {
    static void bubbleSort01(Integer[] arrays) {
        int tmp = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 1; j < arrays.length - i; j++) {
                if (arrays[j-1] < arrays[j]) {
                    tmp = arrays[j-1];
                    arrays[j-1] = arrays[j];
                    arrays[j] = tmp;
                }
            }
        }
    }

    static void bubbleSort02(Integer[] arrays) {
        int tmp = 0;
        for (int end = arrays.length-1; end > 0; end--) {
            for (int j = 1; j <= end; j++) {
                if (arrays[j-1] < arrays[j]) {
                    tmp = arrays[j-1];
                    arrays[j-1] = arrays[j];
                    arrays[j] = tmp;
                }
            }
        }
    }

    static void bubbleSort03(Integer[] arrays) {
        int tmp = 0;
        for (int end = arrays.length-1; end > 0; end--) {
            // 标记数组是否完全有序
            boolean searchState = true;
            for (int j = 1; j <= end; j++) {
                if (arrays[j-1] < arrays[j]) {
                    tmp = arrays[j-1];
                    arrays[j-1] = arrays[j];
                    arrays[j] = tmp;
                    searchState = false;
                }
            }
            if (searchState) break;
        }
    }

    static void bubbleSort04(Integer[] arrays) {
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
        Integer[] array1 = Integers.random(10000,1,1000);
        Integer[] array2 = Integers.copy(array1);
        Integer[] array3 = Integers.copy(array1);
        Integer[] array4 = Integers.copy(array1);
        Times.test("bubbleSort01",() ->{
            bubbleSort01(array1);
        });

        Times.test("bubbleSort02",() ->{
            bubbleSort02(array2);
        });

        Times.test("bubbleSort03",() ->{
            bubbleSort03(array3);
        });

        Times.test("bubbleSort04",() ->{
            bubbleSort04(array4);
        });
    }
}

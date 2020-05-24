package com.douye.sort;

import com.douye.tools.Asserts;
import com.douye.tools.Integers;
import com.douye.tools.Times;

public class 插入排序 {

    static void insertionSort01(Integer[] arrays) {
        Integer tmp = 0;
        for (int i = 1; i < arrays.length; i++) {
            int index = i;
            while (index > 0 && arrays[index] < arrays[index-1]){
                tmp = arrays[index];
                arrays[index] = arrays[index-1];
                arrays[index-1] = tmp;
                index--;
            }
        }
    }

    static void insertionSort02(Integer[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            int index = i;
            int cur = arrays[index];
            while (index > 0 && arrays[index-1] > cur){
                arrays[index] = arrays[index-1];
                index--;
            }
            arrays[index] = cur;
        }
    }

    static void insertionSort03(Integer[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            int cur = arrays[i];
            int dest = BinarySearch.search(arrays,i);
            for (int j = i; j > dest; j--){
                arrays[j] = arrays[j-1];
            }
            arrays[dest] = cur;
        }
    }

    static void test(Integer[] array){
        int search = BinarySearch.search(array, 2);
        System.out.println(search);
    }
    public static void main(String[] args) {
        Integer[] arrays = Integers.random(50000,1,100);
        //Integer[] arrays = {4,5,3,1,2};
        Integer[] copy = Integers.copy(arrays);
        //test(arrays);
        Times.test("insertionSort01",() ->{
            insertionSort01(arrays);
        });
        Asserts.test(Integers.isAscOrder(arrays));
        Times.test("insertionSort03",() ->{
            insertionSort03(copy);
        });
//        for (Integer integer : copy) {
//            System.out.print(integer+" ");
//        }
        Asserts.test(Integers.isAscOrder(copy));
    }
}

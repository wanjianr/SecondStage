package com.douye.sort;

import com.douye.tools.Asserts;
import com.douye.tools.Integers;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array0 = {7, 3, 5, 8, 6, 7, 4, 5};
        Integer[] array = Integers.random(20000,1,2000);
        testSorts(array,
                //new BubbleSort01(),
                new SelectSort(),
                new InsertoinSort03(),
                new MergeSort(),
                new QuickSort()
        );
    }

    static void testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);

        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }
}

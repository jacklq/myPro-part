package com.lq.lqproj.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortAlgorithmTest {

    int[] array = {7, 6, 8, 2, 5, 9};
    SortAlgorithm sortAlgorithm = new SortAlgorithm();

    @Test
    void insertSort() {
        System.out.println("直接插入排序-insertSort  start");
        sortAlgorithm.insertSort(array);
        System.out.println(Arrays.toString(array));

        System.out.println("直接插入排序-insertSort  end");
    }

    @Test
    void sheelSort() {
        System.out.println("希尔排序-sheelSort  start");
        sortAlgorithm.sheelSort(array);
        System.out.println(Arrays.toString(array));

        System.out.println("排序结束-sheelSort  end");
    }

    @Test
    void selectSort() {
        System.out.println("选择排序-selectSort  start");
        sortAlgorithm.selectSort(array);
        System.out.println(Arrays.toString(array));

        System.out.println("排序结束-selectSort  end");
    }

    @Test
    void heapSort() {
        System.out.println("堆排序-heapSort  start");
        sortAlgorithm.selectSort(array);
        System.out.println(Arrays.toString(array));

        System.out.println("堆结束-heapSort  end");

    }

    @Test
    void bubbleSort() {
        System.out.println("堆排序-heapSort  start");
        sortAlgorithm.bubbleSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("堆结束-heapSort  end");
    }

    @Test
    void quickSort() {
        System.out.println("快速排序-quickSort  start");
        sortAlgorithm.quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
        System.out.println("快速结束-quickSort  end");
    }

    @Test
    void mergeSort() {
        System.out.println("合并排序-mergeSort  start");
        sortAlgorithm.mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
        System.out.println("合并结束-mergeSort  end");
    }
}
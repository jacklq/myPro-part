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
    }

    @Test
    void selectSort() {
    }

    @Test
    void heapSort() {
    }

    @Test
    void bubbleSort() {
    }

    @Test
    void quickSort() {
    }

    @Test
    void mergeSort() {
    }
}
package com.zcyfover.dsaa.sort;

import java.util.Arrays;

/**
 * @author zcy-fover
 * @description 排序
 * @date 2020-01-12 15:20
 */
public abstract class Sort {
    /**
     * 排序方法
     * @param arrays 原是数组
     */
    abstract void sort(int[] arrays);

    abstract void betterSort(int[] arrays);

    void print(int[] arrays) {
        System.out.println(Arrays.toString(arrays));
    }

    void swap(int[] arrays, int i, int j) {
        arrays[i] = arrays[i] ^ arrays[j];
        arrays[j] = arrays[i] ^ arrays[j];
        arrays[i] = arrays[i] ^ arrays[j];
    }
}

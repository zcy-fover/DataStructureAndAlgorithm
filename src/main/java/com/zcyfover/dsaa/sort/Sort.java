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

    int getMax(int[] arrays) {
        int max = 0;
        for (int element : arrays) {
            if (max < element) {
                max = element;
            }
        }
        return max;
    }

    /**
     * 将source的元素复制到target中
     * @param source 原数组
     * @param target 目标数组
     */
    void copy(int[] source, int[] target) {
        if (source.length != target.length) {
            return;
        }
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
    }

    void swap(int[] arrays, int i, int j) {
        if (i == j) {
            return;
        }
        arrays[i] = arrays[i] ^ arrays[j];
        arrays[j] = arrays[i] ^ arrays[j];
        arrays[i] = arrays[i] ^ arrays[j];
    }
}

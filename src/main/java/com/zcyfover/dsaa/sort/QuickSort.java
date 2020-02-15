package com.zcyfover.dsaa.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author zcy-fover
 * @description 快速排序，先进行分区然后在递归
 * @date 2020-02-15 16:38
 */
public class QuickSort extends Sort {
    @Override
    void sort(int[] arrays) {
        if (ArrayUtils.isEmpty(arrays)) {
            print(arrays);
        }
        quickSort(arrays, 0, arrays.length - 1);
        print(arrays);
    }

    private void quickSort(int[] arrays, int p, int r) {
        if (p >= r) {
            return;
        }
        //获取分区点
        int q = partition(arrays, p, r);
        quickSort(arrays, p, q - 1);
        quickSort(arrays, q + 1, r);
    }

    private int partition(int[] arrays, int p, int r) {
        //选择最后一个元素作为区分点
        int pivot = arrays[r];
        int i = p;
        for (int j = p; j < r; j++) {
            //如果array[j]比pivot小，需要交换i和j，并且同时向前移动；
            //如果array[j]比pivot大，则不交换，i不动，j继续前进
            if (arrays[j] < pivot) {
                swap(arrays, i, j);
                i = i + 1;
            }
        }
        swap(arrays, i, r);
        return i;
    }

    @Override
    void betterSort(int[] arrays) {
        //双排利用基准值从前往后和从后往前同时进行
        if (ArrayUtils.isEmpty(arrays)) {
            return;
        }
        doubleQuickSort(arrays, 0, arrays.length - 1);
        print(arrays);
    }

    private void doubleQuickSort(int[] arrays, int p, int r) {
        if (p < r) {
            int index = getIndex(arrays, p, r);
            doubleQuickSort(arrays, p, index - 1);
            doubleQuickSort(arrays, index + 1, r);
        }
    }

    private int getIndex(int[] arrays, int low, int high) {
        int temp = arrays[low];
        while (low < high) {
            while (low < high && arrays[high] > temp) {
                high--;
            }
            arrays[low] = arrays[high];
            while (low <high && arrays[low] <= temp) {
                low++;
            }
            arrays[high] = arrays[low];
        }
        arrays[low] = temp;
        return low;
    }

}

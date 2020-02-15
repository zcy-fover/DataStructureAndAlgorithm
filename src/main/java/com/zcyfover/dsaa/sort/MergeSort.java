package com.zcyfover.dsaa.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author zcy-fover
 * @description 归并排序
 * @date 2020-02-15 15:40
 */
public class MergeSort extends Sort {
    @Override
    void sort(int[] arrays) {
        if (ArrayUtils.isEmpty(arrays)) {
            print(arrays);
        }
        mergeSort(arrays, 0, arrays.length - 1);
        print(arrays);
    }

    private void mergeSort(int[] arrays, int p, int r) {
        //终止条件
        if (p >= r) {
            return;
        }
        //将原数组区分，找出中间位置q
        int q = (p + r) / 2;
        //将数组递归循环求解，直至达到终止条件
        mergeSort(arrays, p, q);
        mergeSort(arrays, q + 1, r);
        //合并函数，将子问题的解合并
        merge(arrays, p, q, r);
    }

    private void merge(int[] arrays, int p, int q, int r) {
        int i = p, j = q + 1, k = 0;
        //申请一个和原数组一样大的临时数组
        int[] temp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (arrays[i] < arrays[j]) {
                temp[k++] = arrays[i++];
            } else {
                temp[k++] = arrays[j++];
            }
        }
        //当i或者j循环结束时，可能存在一边元素没有被复制完，需要将剩余元素填入
        int start = i, end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            temp[k++] = arrays[start++];
        }
        for (int n = 0; n < temp.length; n++) {
            arrays[p++] = temp[n];
        }
    }

    @Override
    void betterSort(int[] arrays) {

    }
}

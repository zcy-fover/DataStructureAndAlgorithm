package com.zcyfover.dsaa.sort;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @author zcy-fover
 * @description 冒泡排序
 * @date 2020-01-12 15:08
 */
public class BubbleSort extends Sort {

    @Override
    public void sort(int[] arrays) {
        if (ArrayUtils.isEmpty(arrays)) {
            print(arrays);
        }
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < (length - 1); j++) {
                if (arrays[i] > arrays[j + 1]) {
                    swap(arrays, i, j + 1);
                }
            }
        }
        print(arrays);
    }

    @Override
    void betterSort(int[] arrays) {
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            //设置标志，当元素没有交换时，说明数组已经有序
            boolean flag = false;
            for (int j = i; j < (length - 1); j++) {
                if (arrays[i] > arrays[j + 1]) {
                    swap(arrays, i, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        print(arrays);
    }
}

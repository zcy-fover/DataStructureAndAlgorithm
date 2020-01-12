package com.zcyfover.dsaa.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author zcy-fover
 * @description 选择排序
 * @date 2020-01-12 18:19
 */
public class SelectSort extends Sort {
    @Override
    void sort(int[] arrays) {
        if (ArrayUtils.isEmpty(arrays)) {
            print(arrays);
        }
        int length = arrays.length;
        for (int i = 0; i < length - 1; i++) {
            int j = length - 1, position = length - 1;
            for (; j >= i; j--) {
                //position保存最小元素的位置
                if (arrays[j] < arrays[position]) {
                    position = j;
                }
            }
            //如果最小元素就是当前i，则不动
            if (i != position) {
                swap(arrays, i, position);
            }
        }
        print(arrays);
    }

    @Override
    void betterSort(int[] arrays) {

    }
}

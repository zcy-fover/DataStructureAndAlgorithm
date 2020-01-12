package com.zcyfover.dsaa.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author zcy-fover
 * @description 插入排序
 * @date 2020-01-12 17:14
 */
public class InsertSort extends Sort {
    @Override
    void sort(int[] arrays) {
        if (ArrayUtils.isEmpty(arrays)) {
            print(arrays);
        }
        for (int i = 1; i < arrays.length; i++) {
            int value = arrays[i];
            int j = i - 1;
            //将有序队列，从右往左遍历；（j=-1，结束循环）
            for (; j >= 0; j--) {
                if (value < arrays[j]) {
                    //找到value插入的位置，将当前元素往后移
                    arrays[j + 1] = arrays[j];
                } else {
                    //当value大于或等于a[j]时，即value的插入位置在j+1
                    break;
                }
            }
            arrays[j + 1] = value;
        }
        print(arrays);
    }

    @Override
    void betterSort(int[] arrays) {
        print(arrays);
    }
}

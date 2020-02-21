package com.zcyfover.dsaa.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author zcy-fover
 * @description 计数排序，找出最大元素，初始化计数数组，遍历原序列，
 * 找出对应元素的位置，统计对应元素出现的次数
 * @date 2020-02-21 10:21
 */
public class CountingSort extends Sort {

    /**
     * 这样实现的排序不能保证稳定性
     * @param arrays 原是数组
     */
    @Override
    void sort(int[] arrays) {
        if (ArrayUtils.isSorted(arrays)) {
            return;
        }
        int max = getMax(arrays);
        int size = max + 1;
        int[] countArray = new int[size];
        for (int element : arrays) {
            countArray[element]++;
        }
        int k = 0;
        for (int j = 0; j < size; j++) {
            if (countArray[j] == 0) {
                continue;
            }
            for (int i = 0; i < countArray[j]; i++) {
                arrays[k++] = j;
            }
        }
        print(arrays);
    }

    @Override
    void betterSort(int[] arrays) {
        if (ArrayUtils.isSorted(arrays)) {
            return;
        }
        int max = getMax(arrays);
        int[] countArray = new int[max + 1];
        for (int element : arrays) {
            countArray[element]++;
        }
        //统计小于等于每个元素的个数
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i - 1] + countArray[i];
        }
        //存放排序结果
        int[] result = new int[arrays.length];
        //倒序遍历arrays，寻找将元素有序输出，这样做是为了保证稳定性
        for (int i = arrays.length- 1; i >= 0; i--) {
            int index = countArray[arrays[i]] - 1;
            result[index] = arrays[i];
            countArray[arrays[i]]--;
        }
        arrays = result;
        print(arrays);
    }

    private int getMax(int[] arrays) {
        int max = 0;
        for (int element : arrays) {
            if (max < element) {
                max = element;
            }
        }
        return max;
    }

}

package com.zcyfover.dsaa.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author zcy-fover
 * @description 基数排序，从低位到高位一次对元素排序
 * @date 2020-02-21 10:57
 */
public class RadixSort extends Sort {

    @Override
    void sort(int[] arrays) {
        if (ArrayUtils.isEmpty(arrays)) {
            return;
        }
        int max = getMax(arrays);
        for (int exp = 1; max > exp; exp *= 10) {
            countingSort(arrays, exp);
        }
        print(arrays);
    }

    @Override
    void betterSort(int[] arrays) {

    }

    /**
     * 把元素拆分为个位进行排序，相当于将原来的排序问题划分为，0-9的10个元素的计数排序
     * @param arrays 待排序数组
     * @param exp 指数，计算当前排序的是哪一位
     */
    private void countingSort(int[] arrays, int exp) {
        int[] countArray = new int[10];
        for (int element : arrays) {
            int index = (element / exp) % 10;
            countArray[index]++;
        }
        //统计小于等于每个元素的个数
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i - 1] + countArray[i];
        }
        //存放排序结果
        int[] result = new int[arrays.length];
        //倒序遍历arrays，寻找将元素有序输出，这样做是为了保证稳定性
        for (int i = arrays.length - 1; i >= 0; i--) {
            int countIndex = (arrays[i] / exp) % 10;
            int index = countArray[countIndex] - 1;
            result[index] = arrays[i];
            countArray[countIndex]--;
        }
        copy(result, arrays);
    }

}

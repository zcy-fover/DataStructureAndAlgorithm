package com.zcyfover.dsaa.sort;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zcy-fover
 * @description 桶排序实现
 * @date 2020-02-20 11:10
 */
public class BucketSort extends Sort {

    @Override
    void sort(int[] arrays) {
        if (ArrayUtils.isEmpty(arrays)) {
            return;
        }
        int max = arrays[0], min = arrays[0];
        int n = arrays.length;
        for (int i = 0; i < n; i++) {
            if (arrays[i] < min) {
                min = arrays[i];
            } else if (arrays[i] > max){
                max = arrays[i];
            }
        }
        //桶的个数
        int bucketNum = (max - min) / n + 1;
        //大概获取每个桶的大小
        int bucketSize = getBucketSize(max, n, bucketNum);
        //初始化桶
        int[][] buckets = new int[bucketNum][bucketSize];
        //统计每个桶的元素个数
        int[] indexCount = new int[bucketNum];
        //将每个元素放到对应的桶中
        for (int i = 0; i < n; i++) {
            int index = (arrays[i] - min) / n;
            if (indexCount[index] == buckets[index].length) {
                //如果对应的桶元素已经达到最初设定的桶的大小，则需要扩容
                capacity(buckets, index);
            }
            buckets[index][indexCount[index]] = arrays[i];
            //桶内元素个数加一
            indexCount[index]++;
        }
        Sort quickSort = new QuickSort();
        int k = 0;
        for (int i = 0; i < bucketNum; i++) {
            //如果桶为空，则跳过
            if (ArrayUtils.isEmpty(buckets[i])) {
                continue;
            }
            //桶的大小不是按照实际的元素个数初始化，可能存在空元素。按照实际元素个数赋值
            if (indexCount[i] < buckets[i].length) {
                int[] temp = new int[indexCount[i]];
                for (int m = 0; m < indexCount[i]; m++) {
                    temp[m] = buckets[i][m];
                }
                buckets[i] = temp;
            }
            //对桶进行排序
            quickSort.sort(buckets[i]);
            for (int j = 0; j < indexCount[i]; j++) {
                arrays[k++] = buckets[i][j];
            }
        }
        print(arrays);
    }

    @Override
    void betterSort(int[] arrays) {
        if (ArrayUtils.isEmpty(arrays)) {
            return;
        }
        int max = arrays[0], min = arrays[0];
        int n = arrays.length;
        for (int array : arrays) {
            if (array > max) {
                max = array;
            } else if (array < min) {
                min = array;
            }
        }
        //桶的个数
        int bucketNum = (max - min) / n + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        //初始化一个大小是bucketNum的列表
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int index = (arrays[i] - min) / n;
            buckets.get(index).add(arrays[i]);
        }
        int k = 0;
        for (int i = 0; i < bucketNum; i++) {
            List<Integer> integerList = buckets.get(i);
            Integer[] objects = new Integer[integerList.size()];
            integerList.toArray(objects);
            insertSort(objects);
            for (int j = 0; j < integerList.size(); j++) {
                arrays[k++] = objects[j];
            }
        }
        print(arrays);
    }

    /**
     * 大概计算桶的大小
     * @param max 原数组的最大元素
     * @param n 原数组的长度
     * @param bucketNum 桶的数量
     * @return 返回桶的大小
     */
    private int getBucketSize(int max, int n, int bucketNum) {
        if (n > max) {
            return n / bucketNum;
        }
        return n;
    }

    private void capacity(int[][] buckets, int index) {
        int[] temp = buckets[index];
        int[] newArray = new int[buckets[index].length * 2];
        for (int i = 0; i < temp.length; i++) {
            newArray[i] = temp[i];
        }
        buckets[index] = newArray;
    }

    private void insertSort(Integer[] arrays) {
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
    }

}

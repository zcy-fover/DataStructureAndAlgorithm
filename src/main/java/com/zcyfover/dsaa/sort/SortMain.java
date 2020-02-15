package com.zcyfover.dsaa.sort;

/**
 * @author zcy-fover
 * @description 排序测试方法
 * @date 2020-01-12 15:54
 */
public class SortMain {

    private static int[] source = {2, 4, 9, 4, 3, 1, 5, 6};
    private static int[] sourceTwo = {2, 4, 9, 4, 3, 1, 5, 6};

    private static int[] sortedSource = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        Sort sort;
//        sort = new BubbleSort();
//        sort.betterSort(sortedSource);
//        sort = new InsertSort();
//        sort.sort(source);
//        sort = new SelectSort();
//        sort.sort(source);
//        sort = new MergeSort();
//        sort.sort(source);
        sort = new QuickSort();
        sort.sort(source);
        sort.betterSort(sourceTwo);
    }

}

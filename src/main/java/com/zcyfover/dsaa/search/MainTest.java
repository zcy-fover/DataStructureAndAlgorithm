package com.zcyfover.dsaa.search;

import com.zcyfover.dsaa.search.binary.BinarySearch;

/**
 * @author zcy-fover
 * @description TODO
 * @date 2020-02-25 16:10
 */
public class MainTest {

    private static final int[] SOURCE = {8, 2, 3};
    private static final int[] TEST = {};

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
//        int index = binarySearch.binarySearchOne(TEST, 1);
        int index = binarySearch.binarySearchEight(SOURCE, 3);
        System.out.println(index);
    }

}

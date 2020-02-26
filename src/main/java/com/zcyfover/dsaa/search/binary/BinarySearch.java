package com.zcyfover.dsaa.search.binary;

import com.zcyfover.dsaa.common.constants.NumberConstants;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author zcy-fover
 * @description 二分查找实现以及几个变种问题实现
 * @date 2020-02-25 16:50
 */
public class BinarySearch {

    /**
     * 二分查找最简单实现，序列是有序的且没有重复元素
     * @param array 原数组
     * @param element 要查找的目标元素
     * @return 返回目标元素所在的索引位置
     */
    public int binarySearchOne(int[] array, int element) {
        if (ArrayUtils.isEmpty(array)) {
            return NumberConstants.MINUS_ONE;
        }
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (element < array[mid]) {
                high = mid - 1;
            } else if (element > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return NumberConstants.MINUS_ONE;
    }

    /**
     * 利用递归实现二分查找
     * @param array 原数组
     * @param element 要查找的元素
     * @return 返回元素所在下标
     */
    public int binarySearchTwo(int[] array, int element) {
        if (ArrayUtils.isEmpty(array)) {
            return NumberConstants.MINUS_ONE;
        }

        return NumberConstants.MINUS_ONE;
    }

    private int binarySearchRecurion(int[] array, int low, int high, int element) {
        if (low > high) {
            return NumberConstants.MINUS_ONE;
        }
        int mid = low + ((high - low) >> 1);
        if (array[mid] > element) {
            return binarySearchRecurion(array, low, mid - 1, element);
        } else if (array[mid] < element) {
            return binarySearchRecurion(array, mid + 1, high, element);
        } else {
            return mid;
        }
    }

    /**
     * 在有序序列中查找第一个等于 element 的元素的位置
     * @param array 原有序数组
     * @param element 目标元素
     * @return 返回目标元素在数组中的索引
     */
    public int binarySearchThree(int[] array, int element) {
        if (ArrayUtils.isEmpty(array)) {
            return NumberConstants.MINUS_ONE;
        }
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (element < array[mid]) {
                high = mid - 1;
            } else if (element > array[mid]) {
                low = mid + 1;
            } else {
                // 如果 mid = 0，则序列的第一个元素就是 element，返回 mid
                // 如果 mid != 0，判断前一个元素是否等于 element，不等于则 当前的 mid 就是第一个等于 element 的元素索引
                if (mid == 0 || array[mid - 1] != element) {
                    return mid;
                } else {
                    // 如果 array[mid - 1] == element，就更新 high，从 [low, mid-1]继续查找第一个相等的元素
                    high = mid - 1;
                }
            }
        }
        return NumberConstants.MINUS_ONE;
    }

    /**
     * 在有序序列中查找最后一个等于 element 的元素的位置
     * @param array 原有序数组
     * @param element 目标元素
     * @return 返回目标元素在数组中的索引
     */
    public int binarySearchFour(int[] array, int element) {
        if (ArrayUtils.isEmpty(array)) {
            return NumberConstants.MINUS_ONE;
        }
        int n = array.length - 1;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (element < array[mid]) {
                high = mid - 1;
            } else if (element > array[mid]) {
                low = mid + 1;
            } else {
                // 如果 mid = n - 1，则序列的最后一个元素就是 element，返回 mid
                // 如果 mid != n - 1，判断后一个元素是否等于 element，不等于则 当前的 mid 就是最后一个等于 element 的元素索引
                if (mid == n - 1 || array[mid + 1] != element) {
                    return mid;
                } else {
                    // 如果 array[mid + 1] == element，就更新 low，从 [mid + 1, high]继续查找最后一个相等的元素
                    low = mid + 1;
                }
            }
        }
        return NumberConstants.MINUS_ONE;
    }

    /**
     * 在有序序列中查找第一个大于等于 element 的元素的位置
     * @param array 原有序数组
     * @param element 目标元素
     * @return 返回目标元素在数组中的索引
     */
    public int binarySearchFive(int[] array, int element) {
        if (ArrayUtils.isEmpty(array)) {
            return NumberConstants.MINUS_ONE;
        }
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (element <= array[mid]) {
                if (mid == 0 || array[mid - 1] < element) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return NumberConstants.MINUS_ONE;
    }

    /**
     * 在有序序列中查找最后一个小于等于 element 的元素的位置
     * @param array 原有序数组
     * @param element 目标元素
     * @return 返回目标元素在数组中的索引
     */
    public int binarySearchSix(int[] array, int element) {
        if (ArrayUtils.isEmpty(array)) {
            return NumberConstants.MINUS_ONE;
        }
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (element < array[mid]) {
                high = mid - 1;
            } else {
                if (mid == array.length - 1 || array[mid + 1] > element) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return NumberConstants.MINUS_ONE;
    }

    /**
     * 在一个循环有序数组中二分查找 element 的元素的位置
     * 循环数组存在一个性质：以数组中间点为分区，会将数组分成一个有序数组和一个循环有序数组。
     *    如果首元素小于 mid，说明前半部分是有序的，后半部分是循环有序数组；
     *    如果首元素大于 mid，说明后半部分是有序的，前半部分是循环有序的数组；
     *    如果目标元素在有序数组范围中，使用二分查找；
     *    如果目标元素在循环有序数组中，设定数组边界后，使用以上方法继续查找。
     * array ：[2, 3, 4, 5, 6, 1]
     * @param array 原有序数组
     * @param element 目标元素
     * @return 返回目标元素在数组中的索引
     */
    public int binarySearchSeven(int[] array, int element) {
        if (ArrayUtils.isEmpty(array)) {
            return NumberConstants.MINUS_ONE;
        }
        //首先二分寻找最小元素的位置
        int low = 0, high = array.length - 1;
        int mid = low + ((high - low) >> 1);
        if (mid == 0) {
            if (array[low] == element) {
                return low;
            } else if (array[high] == element) {
                return high;
            } else {
                return NumberConstants.MINUS_ONE;
            }
        }
        if (array[low] <= array[mid]) {
            int[] newArray = Arrays.copyOfRange(array, low, mid);
            int index = binarySearchOne(newArray, element);
            if (index != NumberConstants.MINUS_ONE) {
                return index + low;
            } else {
                int[] tempArray = Arrays.copyOfRange(array, mid, high + 1);
                int result = binarySearchSeven(tempArray, element);
                if (result != NumberConstants.MINUS_ONE) {
                    return mid + result;
                }
                return NumberConstants.MINUS_ONE;
            }
        } else {
            int[] newArray = Arrays.copyOfRange(array, mid + 1, high + 1);
            int index = binarySearchOne(newArray, element);
            if (index != NumberConstants.MINUS_ONE) {
                return index + mid + 1;
            } else {
                int[] tempArray = Arrays.copyOfRange(array, low, mid + 1);
                return binarySearchSeven(tempArray, element);
            }
        }
    }

    /**
     * 在一个循环有序数组中二分查找 element 的元素的位置
     *    将数组二分，如果首元素小于中间元素，则前半部分有序，判断 element 是否在该区间
     *                                 对于无序的部分，继续二分查找
     *              如果首元素大于中间元素，则后半部分有序，判断 element 是否在该区间
     *                                 对于无序的部分，继续二分查找
     * array ：[2, 3, 4, 5, 6, 1]
     * @param array 原有序数组
     * @param element 目标元素
     * @return 返回目标元素在数组中的索引
     */
    public int binarySearchEight(int[] array, int element) {
        if (ArrayUtils.isEmpty(array)) {
            return NumberConstants.MINUS_ONE;
        }
        //首先二分寻找最小元素的位置
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (element == array[mid]) {
                return mid;
            }
            if (array[low] <= array[mid]) {
                if (array[low] <= element && element <= array[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (array[mid] <= element && element <= array[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return NumberConstants.MINUS_ONE;
    }

}

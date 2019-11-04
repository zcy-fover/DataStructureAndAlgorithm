package com.zcyfover.dsaa.stack;

import com.zcyfover.dsaa.common.NumberConstants;
import com.zcyfover.dsaa.common.StringConstants;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zcy-fover
 * @description 链式栈
 * @date 2019-10-28 21:42
 */
public class LinkedStack {

    private List<String> stack;

    private int count;

    private static int MAX_SIZE = NumberConstants.ONE_HUNDRED;

    public LinkedStack() {
        this.stack = new LinkedList<>();
        this.count = NumberConstants.ZERO;
    }

    public boolean push(String item) {
        //如果栈内元素个数等于最大值，则返回栈满，即入栈失败
        if (count == MAX_SIZE) {
            return false;
        }
        stack.add(item);
        count++;
        return true;
    }

    public String pop() {
        //如果栈为空，则直接返回
        if (CollectionUtils.isEmpty(stack)) {
            return StringConstants.EMPTY_STR;
        }
        return stack.remove(--count);
    }

}

package com.zcyfover.dsaa.stack;

import com.zcyfover.dsaa.common.constants.NumberConstants;
import com.zcyfover.dsaa.common.constants.StringConstants;

/**
 * @author zcy-fover
 * @description 基于数组实现的顺序栈：基于数组实现的栈在扩容时需要重新开辟一个更大的空间将当前
 * 栈复制过去
 * @date 2019-10-28 20:52
 */
public class ArrayStack {

    /**
     * 顺序栈
     */
    private String[] stack;
    /**
     * 栈中的元素个数
     */
    private int count;
    /**
     * 栈的大小
     */
    private int n;

    public ArrayStack(int n) {
        this.stack = new String[n];
        this.n = n;
        this.count = NumberConstants.ZERO;
    }

    public boolean push(String item) {
        //首先判断栈是否已满
        if (count == n) {
            return false;
        }
        //将元素item放在count位置，count加一
        stack[count++] = item;
        return true;
    }

    public String pop() {
        //判断栈为空，直接返回空
        if (count == NumberConstants.ZERO) {
            return StringConstants.EMPTY_STR;
        }
        //栈顶元素出栈，栈顶指针后移
        return stack[--count];
    }

}

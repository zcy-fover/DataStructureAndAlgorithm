package com.zcyfover.dsaa.linkedlist.skiplist;

import com.zcyfover.dsaa.common.constants.NumberConstants;

import java.util.Random;

/**
 * @author zcy-fover
 * @description 跳表实现
 * @date 2020-03-01 15:09
 */
public class SkipList {

    private static final int MAX_LEVEL = 16;

    /**
     * 层级计数器
     */
    private int levelCount = 1;

    /**
     * 带头链表
     */
    private SkipNode head = new SkipNode(MAX_LEVEL);

    private Random random = new Random();

    public SkipNode find(int value) {
        SkipNode p = head;
        for (int i = 0; i < levelCount - 1; i++) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        int level = head.forwards[0] == null ? NumberConstants.ONE : randomLevel();
        if (level > levelCount) {
            level = ++levelCount;
        }
        SkipNode newNode = new SkipNode(level);
        newNode.data = value;
        SkipNode[] update = new SkipNode[level];
        for (int i = 0; i < level; ++i) {
            update[i] = head;
        }
        SkipNode p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            if (level > i) {
                update[i] = p;
            }
        }
        for (int i = 0; i < level; i++) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }
    }

    public void delete(int value) {
        SkipNode[] update = new SkipNode[levelCount];
        SkipNode p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    private int randomLevel() {
        int level = 1;
        for (int i = 0; i < MAX_LEVEL; i++) {
            if (random.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    class SkipNode {

        private int data = -1;

        /**
         * 表示当前节点的下一个节点所有层的数据，从上层切换到下层就是数组下标 - 1
         *
         */
        private SkipNode[] forwards;

        private int maxLevel;

        SkipNode(int level) {
            forwards = new SkipNode[level];
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }

    }


}

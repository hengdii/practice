package com.jiaty.demo.leecode.once.intermediate;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @program: practice
 * @description: 扁平化嵌套列表迭代器
 * @author: Jiaty
 * @create: 2021-03-24 01:37
 **/

public class Solution341 {


    public class NestedIterator implements Iterator<Integer> {

        private Stack<NestedInteger> stack = new Stack<NestedInteger>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; --i) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                NestedInteger cur = stack.peek();
                if (cur.isInteger()) {
                    return true;
                }
                stack.pop();
                List<NestedInteger> list = cur.getList();
                for (int i = cur.getList().size() - 1; i >= 0; --i) {
                    stack.push(list.get(i));
                }
            }
            return false;
        }
    }


    public interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }
}
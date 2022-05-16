package code;

import java.util.Deque;
import java.util.LinkedList;



public class lc155 {
    static class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int val) {
            stack.addLast(val);
            if (minStack.isEmpty() || val <= minStack.peekLast()) {
                minStack.addLast(val);
            }
        }

        public void pop() {
            int popVal = stack.removeLast();
            if (popVal == minStack.peekLast()) {
                minStack.removeLast();
            }
        }

        public int top() {
            return stack.peekLast();
        }

        public int getMin() {
            return minStack.peekLast();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

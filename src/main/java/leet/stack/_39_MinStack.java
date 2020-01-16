package leet.stack;

import leet.ICodePoints;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *  push(x) – Push element x onto stack.
 *  pop() – Removes the element on top of the stack.
 *  top() – Get the top element..
 * @see  leet.ICodePoints()
 *  getMin() – Retrieve the minimum element in the stack.
 */
public class _39_MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    /** initialize your data structure here. */
    public _39_MinStack() {

    }

    @ICodePoints("方法一 O(n) runtime, O(n) space – Extra stack:|| " +
            "需要一个额外的栈记录")
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }else {
            minStack.push(minStack.peek());
        }
    }
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}


//////////////////////////////
@ICodePoints("优化点  minStack可以存最小值的集合||要考虑重复值的情况")
class MInStack{
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    /** initialize your data structure here. */
    public MInStack() {

    }

    @ICodePoints("方法一 O(n) runtime, O(n) space – Extra stack:|| " +
            "需要一个额外的栈记录")
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek() ) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


}

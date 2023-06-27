import java.util.Deque;
import java.util.LinkedList;

public class LC_minStack {
    /**
     * 力扣最小栈
     */
    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            stack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            // minStack存储的是到目前为止，最小的值，每进来一次，判断一次，重新存储一次
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            stack.pop();
            // 因为minStack每次都是重新判断，重新存储最小，所以删除时，也要删除一次
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}

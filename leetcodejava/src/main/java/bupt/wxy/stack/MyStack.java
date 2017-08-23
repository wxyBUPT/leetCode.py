package bupt.wxy.stack;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by xiyuanbupt on 2/14/17.
 225. Implement Stack using Queues
 Difficulty: Easy
 Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.
 Notes:
 You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 Credits:
 Special thanks to @jianchao.li.fighter for adding this problem and all test cases.

 Subscribe to see which companies asked this question.
 */
public class MyStack {

    // 53.77%
    Queue<Integer> queue=new ArrayDeque<>();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        for(int i=0,count=queue.size()-1;i<count;i++){
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

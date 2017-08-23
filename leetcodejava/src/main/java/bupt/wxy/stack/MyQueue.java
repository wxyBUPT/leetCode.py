package bupt.wxy.stack;

import java.util.Stack;

/**
 * Created by xiyuanbupt on 1/13/17.
 232. Implement Queue using Stacks
 Difficulty: Easy
 Implement the following operations of a queue using stacks.

 push(x) -- Push element x to the back of queue.
 pop() -- Removes the element from in front of queue.
 peek() -- Get the front element.
 empty() -- Return whether the queue is empty.
 Notes:
 You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class MyQueue {

    // 61.89%
    Stack<Integer> left=new Stack<>();
    Stack<Integer> right=new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        left.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        right.pop();
    }

    // Get the front element.
    public int peek() {
        if(right.isEmpty()){
            while (!left.isEmpty()){
                right.push(left.pop());
            }
        }
        return right.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return left.isEmpty()&&right.isEmpty();
    }
}

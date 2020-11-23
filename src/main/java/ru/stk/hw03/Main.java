package ru.stk.hw03;

import ru.stk.hw03.deque.Deque;
import ru.stk.hw03.deque.DequeImpl;
import ru.stk.hw03.queue.Queue;
import ru.stk.hw03.queue.QueueImpl;
import ru.stk.hw03.stack.Stack;
import ru.stk.hw03.stack.StackImpl;
import ru.stk.hw03.stack.StringOps;

public class Main {

    public static void main(String[] args) {
        //testStack();
        //testQueue();
        //testRevertString();
        testDeque();
    }

    private static void testRevertString(){
        StringOps so = new StringOps("public void push(E value) {\n" +
                "                    data[size++] = value;\n" +
                "                }");
        String res = so.revert();
        System.out.println(res);

    }

    private static void testStack() {
        Stack<Integer> stack = new StackImpl<>(5);

        System.out.println("Add value 1: " + addToStack(stack, 1));
        System.out.println("Add value 2: " + addToStack(stack, 2));
        System.out.println("Add value 3: " + addToStack(stack, 3));
        System.out.println("Add value 4: " + addToStack(stack, 4));
        System.out.println("Add value 5: " + addToStack(stack, 5));
        System.out.println("Add value 6: " + addToStack(stack, 6));

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static boolean addToStack(Stack<Integer> stack, int value) {
        if (!stack.isFull()) {
            stack.push(value);
            return true;
        }
        return false;
    }

    private static void testQueue() {
        Queue<Integer> queue = new QueueImpl<>(5);
        System.out.println(queue.insert(3));
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(2));
        System.out.println(queue.insert(6));
        System.out.println(queue.insert(4));

        System.out.println("Queue peek: " + queue.peekHead());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    private static void testDeque() {
        Deque<Integer> dq = new DequeImpl<>(5);
        System.out.println(dq.insertRight(3));
        System.out.println(dq.insertRight(5));
        System.out.println(dq.insertRight(1));
        System.out.println(dq.insertLeft(2));
        System.out.println(dq.insertLeft(6));
        //System.out.println(dq.insertRight(4));

        System.out.println("Queue peek: " + dq.peekHead());
        System.out.println("Queue size: " + dq.size());
        System.out.println("Queue is full: " + dq.isFull());

        while (!dq.isEmpty()) {
            System.out.println(dq.removeRight());
        }
    }
}

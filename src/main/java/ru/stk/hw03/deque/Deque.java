package ru.stk.hw03.deque;

import ru.stk.hw03.queue.Queue;

public interface Deque<E> extends Queue<E> {

    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();

}

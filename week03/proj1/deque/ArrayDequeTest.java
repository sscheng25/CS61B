package deque;

import org.junit.Test;

public class ArrayDequeTest {

    @Test
    /* Add small number of elements to deque; check if order is correct. */
    public void smallLLDequeTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        lld1.addFirst(100);
        lld1.addFirst(200);
        lld1.addFirst(300);
        lld1.addFirst(400);
        lld1.addFirst(500);
        lld1.addFirst(600);
        lld1.addFirst(700);
        lld1.addFirst(800);
        lld1.addFirst(900);
        lld1.addFirst(1000);
        System.out.println(lld1.get(4));
    }

    @Test
    public void addLastTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        lld1.addLast(100);
        lld1.addLast(200);
        lld1.addLast(300);
        lld1.addLast(400);
        lld1.addLast(500);
        lld1.addLast(600);
        lld1.addLast(700);
        lld1.addLast(800);
        lld1.addLast(900);
        lld1.addLast(1000);
        System.out.println(lld1.get(4));
    }
}

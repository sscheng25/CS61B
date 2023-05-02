package randomizedtest;

import org.junit.Test;
import edu.princeton.cs.algs4.StdRandom;

import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */


public class TestBuggyAList {
    // private StdRandom StdRandom;

    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                // System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // getLast
                if(correct.size() > 0) {
                    assertEquals(correct.size(), broken.size());
                    assertEquals(correct.getLast(), broken.getLast());
                }
            } else if (operationNumber == 2) {
                // removeLast
                if(correct.size() > 0) {
                    assertEquals(correct.size(), broken.size());
                    assertEquals(correct.removeLast(), broken.removeLast());
                }
            }
        }
    }

    @Test
    public void printNum() {
        System.out.println(7/4);
    }
}

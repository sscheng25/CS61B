package IntList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSelf1() {
        IntList lst = IntList.of(2, 3, 4, 5);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 9 -> 4 -> 25", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSelf2() {
        // IntList lst = IntList.of(0, 1, 2, 3, 4);
        boolean isPrime = Primes.isPrime(3);
        // assertEquals("0 -> 1 -> 4 -> 9 -> 4", lst.toString());
        assertTrue(isPrime);
    }
}

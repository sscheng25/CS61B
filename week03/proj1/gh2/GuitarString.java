package gh2;

import deque.ArrayDeque;
import deque.Deque;

//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private Deque<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        int cp = (int) Math.round(SR / frequency);
        buffer = new ArrayDeque<Double>();
        while (cp > 0) {
            buffer.addLast(0.0);
            cp --;
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        int size = buffer.size();
        while (size > 0) {
            buffer.removeFirst();
            double r = Math.random() - 0.5;
            buffer.addLast(r);
            size --;
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double first = buffer.removeFirst();
        double second = buffer.removeFirst();
        double mix = (first + second) / 2 * DECAY;
        buffer.addLast(second);
        buffer.addLast(mix);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        double first = buffer.removeFirst();
        buffer.addFirst(first);
        return first;
    }
}


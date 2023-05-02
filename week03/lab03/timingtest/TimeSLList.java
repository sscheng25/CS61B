package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void doAdd(SLList<Integer> ls, int m) {
        for (int i=0; i<m; i+=1) {
            ls.addLast(1);
        }
    }

    public static void doGet(SLList<Integer> ls, int m) {
        for (int i=0; i<m; i+=1) {
            ls.getLast();
        }
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> a = new AList<Integer>();
        AList<Double> t = new AList<Double>();
        AList<Integer> o = new AList<Integer>();

        for (int i=1000; i<=128000; i*=2) {
            a.addLast(i);
            SLList<Integer> ls = new SLList<Integer>();
            doAdd(ls, i);
            Stopwatch sw = new Stopwatch();
            doGet(ls, 10000);
            double timeInSeconds = sw.elapsedTime();
            t.addLast(timeInSeconds);
            o.addLast(10000);
        }
        System.out.println("Timing table for getsLast");
        printTimingTable(a, t, o);

    }

}

package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void runMultiTime(int n) {
        AList<Integer> a = new AList<Integer>();
        for (int i=0; i<n; i+=1) {
            a.addLast(1);
        }
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE

        AList<Integer> a = new AList<Integer>();
        AList<Double> t = new AList<Double>();
        AList<Integer> o = new AList<Integer>();

        for (int i=1000; i<=128000; i*=2) {
            a.addLast(i);
            Stopwatch sw = new Stopwatch();
            runMultiTime(i);
            double timeInSeconds = sw.elapsedTime();

            t.addLast(timeInSeconds);
            o.addLast(i);
        }

        System.out.println("Timing table for addLast");
        printTimingTable(a, t, o);

    }
}

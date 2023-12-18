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

    public static void timeAListConstruction() {
        System.out.printf("Timing table for addLast\n");
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int n = 8;
        for (int i = 0; i < n; i += 1) {
            int k = (1 << i) * 1000;
            Ns.addLast(k);
            Stopwatch sw = new Stopwatch();
            AList<Integer> al = new AList<>();
            for (int j = 0; j < k; j += 1) {
                al.addLast(j);
            }
            times.addLast(sw.elapsedTime());
            opCounts.addLast(al.size());

        }
        printTimingTable(Ns, times, opCounts);
    }
}

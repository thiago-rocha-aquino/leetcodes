import java.util.Arrays;

public class MergeIntervalsMain {
    public static void main(String[] args) {
        MergeIntervalsSolution solution = new MergeIntervalsSolution();

        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution.merge(input);

        System.out.println("Intervalos originais: " + Arrays.deepToString(input));
        System.out.println("Intervalos fundidos:  " + Arrays.deepToString(result));
        //[[1, 6], [8, 10], [15, 18]]
    }
}

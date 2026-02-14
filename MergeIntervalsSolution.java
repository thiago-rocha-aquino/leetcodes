import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervalsSolution {
    
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Ordenar os intervalos baseando-se no tempo de início (primeiro elemento)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        // Começamos com o primeiro intervalo
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Há sobreposição: atualizamos o fim do intervalo atual
                // para o maior valor entre os dois fins
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Não há sobreposição: passamos para o próximo intervalo
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        // Convertendo a lista de volta para array de arrays
        return merged.toArray(new int[merged.size()][]);
    }
}

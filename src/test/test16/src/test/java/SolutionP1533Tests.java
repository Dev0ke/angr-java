import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1533Tests {
    static class ArrayReaderImpl implements SolutionP1533.ArrayReader {
        private final int len;
        private final int[] preSum;

        public ArrayReaderImpl(int[] arr) {
            this.len = arr.length;
            preSum = new int[len + 1];
            for (int i = 0; i < len; i++) {
                preSum[i + 1] = preSum[i] + arr[i];
            }
        }

        @Override
        public int compareSub(int l, int r, int x, int y) {
            int sum1 = preSum[r + 1] - preSum[l];
            int sum2 = preSum[y + 1] - preSum[x];
            return Integer.compare(sum1, sum2);
        }

        @Override
        public int length() {
            return len;
        }
    }

    private final SolutionP1533 solutionP1533 = new SolutionP1533();

    @Test
    public void example1() {
        int[] arr = {7, 7, 7, 7, 10, 7, 7, 7};
        SolutionP1533.ArrayReader reader = new ArrayReaderImpl(arr);
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1533.getIndex(reader));
    }

    @Test
    public void example2() {
        int[] arr = {6, 6, 12};
        SolutionP1533.ArrayReader reader = new ArrayReaderImpl(arr);
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1533.getIndex(reader));
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP702Tests {
    static class ArrayReaderImpl implements SolutionP702.ArrayReader {
        private final int[] secret;
        private final int n;

        public ArrayReaderImpl(int[] secret) {
            this.secret = secret;
            n = secret.length;
        }

        @Override
        public int get(int index) {
            return (index < n) ? secret[index] : Integer.MAX_VALUE;
        }
    }

    private final SolutionP702 solutionP702 = new SolutionP702();

    @Test
    public void example1() {
        int[] secret = {-1, 0, 3, 5, 9, 12};
        SolutionP702.ArrayReader reader = new ArrayReaderImpl(secret);
        int target = 9;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP702.search(reader, target));
    }

    @Test
    public void example2() {
        int[] secret = {-1, 0, 3, 5, 9, 12};
        SolutionP702.ArrayReader reader = new ArrayReaderImpl(secret);
        int target = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solutionP702.search(reader, target));
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3037Tests {
    static class InfiniteStreamImpl implements SolutionP3037.InfiniteStream {
        int[] bits;
        int idx;

        public InfiniteStreamImpl(int[] bits) {
            this.bits = bits;
            idx = 0;
        }

        @Override
        public int next() {
            return bits[idx++];
        }
    }

    private final SolutionP3037 solutionP3037 = new SolutionP3037();

    @Test
    public void example1() {
        int[] bits = {1, 1, 1, 0, 1, 1, 1};
        InfiniteStreamImpl infiniteStream = new InfiniteStreamImpl(bits);
        int[] pattern = {0, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3037.findPattern(infiniteStream, pattern));
    }

    @Test
    public void example2() {
        int[] bits = {0, 0, 0, 0};
        InfiniteStreamImpl infiniteStream = new InfiniteStreamImpl(bits);
        int[] pattern = {0};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3037.findPattern(infiniteStream, pattern));
    }

    @Test
    public void example3() {
        int[] bits = {1, 0, 1, 1, 0, 1, 1, 0, 1};
        InfiniteStreamImpl infiniteStream = new InfiniteStreamImpl(bits);
        int[] pattern = {1, 1, 0, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3037.findPattern(infiniteStream, pattern));
    }
}
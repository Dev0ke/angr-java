import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2936Tests {
    static class BigArrayImpl implements SolutionP2936.BigArray {
        int[] elements;

        public BigArrayImpl(int[] elements) {
            this.elements = elements;
        }

        @Override
        public int at(long index) {
            return elements[(int) index];
        }

        @Override
        public long size() {
            return elements.length;
        }
    }

    private final SolutionP2936 solutionP2936 = new SolutionP2936();

    @Test
    public void example1() {
        int[] elements = {3, 3, 3, 3, 3};
        BigArrayImpl nums = new BigArrayImpl(elements);
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2936.countBlocks(nums));
    }

    @Test
    public void example2() {
        int[] elements = {1, 1, 1, 3, 9, 9, 9, 2, 10, 10};
        BigArrayImpl nums = new BigArrayImpl(elements);
        int expected = 5;
        Assertions.assertEquals(expected, solutionP2936.countBlocks(nums));
    }

    @Test
    public void example3() {
        int[] elements = {1, 2, 3, 4, 5, 6, 7};
        BigArrayImpl nums = new BigArrayImpl(elements);
        int expected = 7;
        Assertions.assertEquals(expected, solutionP2936.countBlocks(nums));
    }
}
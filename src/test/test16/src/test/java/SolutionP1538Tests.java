import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1538Tests {
    static class ArrayReaderImpl implements SolutionP1538.ArrayReader {
        int[] nums;

        public ArrayReaderImpl(int[] nums) {
            this.nums = nums;
        }

        @Override
        public int query(int a, int b, int c, int d) {
            int sum = nums[a] + nums[b] + nums[c] + nums[d];
            if (sum == 0 || sum == 4) return 4;
            if (sum == 1 || sum == 3) return 2;
            return 0;
        }

        @Override
        public int length() {
            return nums.length;
        }
    }

    private final SolutionP1538 solutionP1538 = new SolutionP1538();

    @Test
    public void example1() {
        int[] nums = {0, 0, 1, 0, 1, 1, 1, 1};
        ArrayReaderImpl arrayReader = new ArrayReaderImpl(nums);
        // 索引 2, 4, 6, 7 也是正确答案。
//        int expected = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1538.guessMajority(arrayReader));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 1, 1, 0};
        ArrayReaderImpl arrayReader = new ArrayReaderImpl(nums);
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1538.guessMajority(arrayReader));
    }

    @Test
    public void example3() {
        int[] nums = {1, 0, 1, 0, 1, 0, 1, 0};
        ArrayReaderImpl arrayReader = new ArrayReaderImpl(nums);
        int expected = -1;
        Assertions.assertEquals(expected, solutionP1538.guessMajority(arrayReader));
    }
}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3003Tests {
    private final Solution3003 solution3003 = new Solution3003();

    @Test
    public void example1() {
        String s = "accca";
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution3003.maxPartitionsAfterOperations(s, k));
    }

    @Test
    public void example2() {
        String s = "aabaab";
        int k = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution3003.maxPartitionsAfterOperations(s, k));
    }

    @Test
    public void example3() {
        String s = "xxyz";
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution3003.maxPartitionsAfterOperations(s, k));
    }
}
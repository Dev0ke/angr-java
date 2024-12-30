import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1987Tests {
    private final Solution1987 solution1987 = new Solution1987();

    @Test
    public void example1() {
        String binary = "001";
        int expected = 2;
        Assertions.assertEquals(expected, solution1987.numberOfUniqueGoodSubsequences(binary));
        Assertions.assertEquals(expected, solution1987.numberOfUniqueGoodSubsequences2(binary));
    }

    @Test
    public void example2() {
        String binary = "11";
        int expected = 2;
        Assertions.assertEquals(expected, solution1987.numberOfUniqueGoodSubsequences(binary));
        Assertions.assertEquals(expected, solution1987.numberOfUniqueGoodSubsequences2(binary));
    }

    @Test
    public void example3() {
        String binary = "101";
        int expected = 5;
        Assertions.assertEquals(expected, solution1987.numberOfUniqueGoodSubsequences(binary));
        Assertions.assertEquals(expected, solution1987.numberOfUniqueGoodSubsequences2(binary));
    }
}

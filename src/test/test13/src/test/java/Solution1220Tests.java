import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1220Tests {
    private final Solution1220 solution1220 = new Solution1220();

    @Test
    public void example1() {
        int n = 1;
        int expected = 5;
        Assertions.assertEquals(expected, solution1220.countVowelPermutation(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int expected = 10;
        Assertions.assertEquals(expected, solution1220.countVowelPermutation(n));
    }

    @Test
    public void example3() {
        int n = 5;
        int expected = 68;
        Assertions.assertEquals(expected, solution1220.countVowelPermutation(n));
    }
}
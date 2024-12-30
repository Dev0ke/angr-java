import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2843Tests {
    private final Solution2843 solution2843 = new Solution2843();

    @Test
    public void example1() {
        int low = 1;
        int high = 100;
        int expected = 9;
        Assertions.assertEquals(expected, solution2843.countSymmetricIntegers(low, high));
    }

    @Test
    public void example2() {
        int low = 1200;
        int high = 1230;
        int expected = 4;
        Assertions.assertEquals(expected, solution2843.countSymmetricIntegers(low, high));
    }
}
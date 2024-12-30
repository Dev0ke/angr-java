import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1850Tests {
    private final Solution1850 solution1850 = new Solution1850();

    @Test
    public void example1() {
        String num = "5489355142";
        int k = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution1850.getMinSwaps(num, k));
    }

    @Test
    public void example2() {
        String num = "11112";
        int k = 4;
        int expected = 4;
        Assertions.assertEquals(expected, solution1850.getMinSwaps(num, k));
    }

    @Test
    public void example3() {
        String num = "00123";
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1850.getMinSwaps(num, k));
    }
}
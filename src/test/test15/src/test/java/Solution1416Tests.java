import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1416Tests {
    private final Solution1416 solution1416 = new Solution1416();

    @Test
    public void example1() {
        String s = "1000";
        int k = 10000;
        int expected = 1;
        Assertions.assertEquals(expected, solution1416.numberOfArrays(s, k));
    }

    @Test
    public void example2() {
        String s = "1000";
        int k = 10;
        int expected = 0;
        Assertions.assertEquals(expected, solution1416.numberOfArrays(s, k));
    }

    @Test
    public void example3() {
        String s = "1317";
        int k = 2000;
        int expected = 8;
        Assertions.assertEquals(expected, solution1416.numberOfArrays(s, k));
    }

    @Test
    public void example4() {
        String s = "2020";
        int k = 30;
        int expected = 1;
        Assertions.assertEquals(expected, solution1416.numberOfArrays(s, k));
    }

    @Test
    public void example5() {
        String s = "1234567890";
        int k = 90;
        int expected = 34;
        Assertions.assertEquals(expected, solution1416.numberOfArrays(s, k));
    }
}
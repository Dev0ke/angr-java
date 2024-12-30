import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1505Tests {
    private final Solution1505 solution1505 = new Solution1505();

    @Test
    public void example1() {
        String num = "4321";
        int k = 4;
        String expected = "1342";
        Assertions.assertEquals(expected, solution1505.minInteger(num, k));
    }

    @Test
    public void example2() {
        String num = "100";
        int k = 1;
        String expected = "010";
        Assertions.assertEquals(expected, solution1505.minInteger(num, k));
    }

    @Test
    public void example3() {
        String num = "36789";
        int k = 1000;
        String expected = "36789";
        Assertions.assertEquals(expected, solution1505.minInteger(num, k));
    }

    @Test
    public void example4() {
        String num = "22";
        int k = 22;
        String expected = "22";
        Assertions.assertEquals(expected, solution1505.minInteger(num, k));
    }

    @Test
    public void example5() {
        String num = "9438957234785635408";
        int k = 23;
        String expected = "0345989723478563548";
        Assertions.assertEquals(expected, solution1505.minInteger(num, k));
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1404Tests {
    private final Solution1404 solution1404 = new Solution1404();

    @Test
    public void example1() {
        String s = "1101";
        int expected = 6;
        Assertions.assertEquals(expected, solution1404.numSteps(s));
    }

    @Test
    public void example2() {
        String s = "10";
        int expected = 1;
        Assertions.assertEquals(expected, solution1404.numSteps(s));
    }

    @Test
    public void example3() {
        String s = "1";
        int expected = 0;
        Assertions.assertEquals(expected, solution1404.numSteps(s));
    }
}
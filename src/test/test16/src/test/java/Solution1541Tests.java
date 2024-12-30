import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1541Tests {
    private final Solution1541 solution1541 = new Solution1541();

    @Test
    public void example1() {
        String s = "(()))";
        int expected = 1;
        Assertions.assertEquals(expected, solution1541.minInsertions(s));
    }

    @Test
    public void example2() {
        String s = "())";
        int expected = 0;
        Assertions.assertEquals(expected, solution1541.minInsertions(s));
    }

    @Test
    public void example3() {
        String s = "))())(";
        int expected = 3;
        Assertions.assertEquals(expected, solution1541.minInsertions(s));
    }

    @Test
    public void example4() {
        String s = "((((((";
        int expected = 12;
        Assertions.assertEquals(expected, solution1541.minInsertions(s));
    }

    @Test
    public void example5() {
        String s = ")))))))";
        int expected = 5;
        Assertions.assertEquals(expected, solution1541.minInsertions(s));
    }
}
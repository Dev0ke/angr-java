import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1415Tests {
    private final Solution1415 solution1415 = new Solution1415();

    @Test
    public void example1() {
        int n = 1;
        int k = 3;
        String expected = "c";
        Assertions.assertEquals(expected, solution1415.getHappyString(n, k));
    }

    @Test
    public void example2() {
        int n = 1;
        int k = 4;
        String expected = "";
        Assertions.assertEquals(expected, solution1415.getHappyString(n, k));
    }

    @Test
    public void example3() {
        int n = 3;
        int k = 9;
        String expected = "cab";
        Assertions.assertEquals(expected, solution1415.getHappyString(n, k));
    }

    @Test
    public void example4() {
        int n = 2;
        int k = 7;
        String expected = "";
        Assertions.assertEquals(expected, solution1415.getHappyString(n, k));
    }

    @Test
    public void example5() {
        int n = 10;
        int k = 100;
        String expected = "abacbabacb";
        Assertions.assertEquals(expected, solution1415.getHappyString(n, k));
    }
}
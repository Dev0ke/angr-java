import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1849Tests {
    private final Solution1849 solution1849 = new Solution1849();

    @Test
    public void example1() {
        String s = "1234";
        Assertions.assertFalse(solution1849.splitString(s));
    }

    @Test
    public void example2() {
        String s = "050043";
        Assertions.assertTrue(solution1849.splitString(s));
    }

    @Test
    public void example3() {
        String s = "9080701";
        Assertions.assertFalse(solution1849.splitString(s));
    }

    @Test
    public void example4() {
        String s = "10009998";
        Assertions.assertTrue(solution1849.splitString(s));
    }
}
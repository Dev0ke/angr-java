import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution466Tests {
    private final Solution466 solution466 = new Solution466();

    @Test
    public void example1() {
        String s1 = "acb";
        int n1 = 4;
        String s2 = "ab";
        int n2 = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution466.getMaxRepetitions(s1, n1, s2, n2));
    }

    @Test
    public void example2() {
        String s1 = "acb";
        int n1 = 1;
        String s2 = "acb";
        int n2 = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution466.getMaxRepetitions(s1, n1, s2, n2));
    }
}
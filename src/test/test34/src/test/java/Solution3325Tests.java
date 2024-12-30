import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3325Tests {
    private final Solution3325 solution3325 = new Solution3325();

    @Test
    public void example1() {
        String s = "abacb";
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution3325.numberOfSubstrings(s, k));
    }

    @Test
    public void example2() {
        String s = "abcde";
        int k = 1;
        int expected = 15;
        Assertions.assertEquals(expected, solution3325.numberOfSubstrings(s, k));
    }
}
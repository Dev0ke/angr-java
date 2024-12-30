import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution955Tests {
    private final Solution955 solution955 = new Solution955();

    @Test
    public void example1() {
        String[] strs = {"ca", "bb", "ac"};
        int expected = 1;
        Assertions.assertEquals(expected, solution955.minDeletionSize(strs));
    }

    @Test
    public void example2() {
        String[] strs = {"xc", "yb", "za"};
        int expected = 0;
        Assertions.assertEquals(expected, solution955.minDeletionSize(strs));
    }

    @Test
    public void example3() {
        String[] strs = {"zyx", "wvu", "tsr"};
        int expected = 3;
        Assertions.assertEquals(expected, solution955.minDeletionSize(strs));
    }
}
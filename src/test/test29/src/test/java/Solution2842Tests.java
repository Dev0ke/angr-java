import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2842Tests {
    private final Solution2842 solution2842 = new Solution2842();

    @Test
    public void example1() {
        String s = "bcca";
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution2842.countKSubsequencesWithMaxBeauty(s, k));
    }

    @Test
    public void example2() {
        String s = "abbcd";
        int k = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution2842.countKSubsequencesWithMaxBeauty(s, k));
    }
}
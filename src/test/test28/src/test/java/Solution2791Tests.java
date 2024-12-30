import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2791Tests {
    private final Solution2791 solution2791 = new Solution2791();

    @Test
    public void example1() {
        List<Integer> parent = List.of(-1, 0, 0, 1, 1, 2);
        String s = "acaabc";
        long expected = 8;
        Assertions.assertEquals(expected, solution2791.countPalindromePaths(parent, s));
    }

    @Test
    public void example2() {
        List<Integer> parent = List.of(-1, 0, 0, 0, 0);
        String s = "aaaaa";
        long expected = 10;
        Assertions.assertEquals(expected, solution2791.countPalindromePaths(parent, s));
    }
}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1528Tests {
    private final Solution1528 solution1528 = new Solution1528();

    @Test
    public void example1() {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        String expected = "leetcode";
        Assertions.assertEquals(expected, solution1528.restoreString(s, indices));
    }

    @Test
    public void example2() {
        String s = "abc";
        int[] indices = {0, 1, 2};
        String expected = "abc";
        Assertions.assertEquals(expected, solution1528.restoreString(s, indices));
    }

    @Test
    public void example3() {
        String s = "aiohn";
        int[] indices = {3, 1, 4, 2, 0};
        String expected = "nihao";
        Assertions.assertEquals(expected, solution1528.restoreString(s, indices));
    }

    @Test
    public void example4() {
        String s = "aaiougrt";
        int[] indices = {4, 0, 2, 6, 7, 3, 1, 5};
        String expected = "arigatou";
        Assertions.assertEquals(expected, solution1528.restoreString(s, indices));
    }

    @Test
    public void example5() {
        String s = "art";
        int[] indices = {1, 0, 2};
        String expected = "rat";
        Assertions.assertEquals(expected, solution1528.restoreString(s, indices));
    }
}

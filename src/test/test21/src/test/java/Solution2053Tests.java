import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2053Tests {
    private final Solution2053 solution2053 = new Solution2053();

    @Test
    public void example1() {
        String[] arr = {"d", "b", "c", "b", "c", "a"};
        int k = 2;
        String expected = "a";
        Assertions.assertEquals(expected, solution2053.kthDistinct(arr, k));
    }

    @Test
    public void example2() {
        String[] arr = {"aaa", "aa", "a"};
        int k = 1;
        String expected = "aaa";
        Assertions.assertEquals(expected, solution2053.kthDistinct(arr, k));
    }

    @Test
    public void example3() {
        String[] arr = {"a", "b", "a"};
        int k = 3;
        String expected = "";
        Assertions.assertEquals(expected, solution2053.kthDistinct(arr, k));
    }
}

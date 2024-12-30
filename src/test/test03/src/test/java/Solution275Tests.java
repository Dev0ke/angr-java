import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution275Tests {
    private final Solution275 solution275 = new Solution275();

    @Test
    public void example1() {
        int[] citations = {0, 1, 3, 5, 6};
        int expected = 3;
        Assertions.assertEquals(expected, solution275.hIndex(citations));
    }

    @Test
    public void example2() {
        int[] citations = {1, 2, 100};
        int expected = 2;
        Assertions.assertEquals(expected, solution275.hIndex(citations));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] citations = {0};
        int expected = 0;
        Assertions.assertEquals(expected, solution275.hIndex(citations));
    }

    @Test
    public void example4() {
        int[] citations = {1};
        int expected = 1;
        Assertions.assertEquals(expected, solution275.hIndex(citations));
    }

    @Test
    public void example5() {
        int[] citations = {100};
        int expected = 1;
        Assertions.assertEquals(expected, solution275.hIndex(citations));
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1238Tests {
    private final Solution1238 solution1238 = new Solution1238();

    @Test
    public void example1() {
        int n = 2;
        int start = 3;
        List<Integer> expected = List.of(3, 2, 0, 1);
        Assertions.assertEquals(expected, solution1238.circularPermutation(n, start));
    }

    @Test
    public void example2() {
        int n = 3;
        int start = 2;
        // 答案不唯一
//        List<Integer> expected = List.of(2, 6, 7, 5, 4, 0, 1, 3);
        List<Integer> expected = List.of(2, 3, 1, 0, 4, 5, 7, 6);
        Assertions.assertEquals(expected, solution1238.circularPermutation(n, start));
    }
}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution825Tests {
    private final Solution825 solution825 = new Solution825();

    @Test
    public void example1() {
        int[] ages = {16, 16};
        int expected = 2;
        Assertions.assertEquals(expected, solution825.numFriendRequests(ages));
    }

    @Test
    public void example2() {
        int[] ages = {16, 17, 18};
        int expected = 2;
        Assertions.assertEquals(expected, solution825.numFriendRequests(ages));
    }

    @Test
    public void example3() {
        int[] ages = {20, 30, 100, 110, 120};
        int expected = 3;
        Assertions.assertEquals(expected, solution825.numFriendRequests(ages));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/411785751/
        // 去掉 < 15 限制情况
        int[] ages = {108, 115, 5, 24, 82};
        int expected = 3;
        Assertions.assertEquals(expected, solution825.numFriendRequests(ages));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/411785957/
        // 去掉 < 15 限制情况
        int[] ages = {118, 14, 7, 63, 103};
        int expected = 2;
        Assertions.assertEquals(expected, solution825.numFriendRequests(ages));
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2030Tests {
    private final Solution2030 solution2030 = new Solution2030();

    @Test
    public void example1() {
        String s = "leet";
        int k = 3;
        char letter = 'e';
        int repetition = 1;
        String expected = "eet";
        Assertions.assertEquals(expected, solution2030.smallestSubsequence(s, k, letter, repetition));
    }

    @Test
    public void example2() {
        String s = "leetcode";
        int k = 4;
        char letter = 'e';
        int repetition = 2;
        String expected = "ecde";
        Assertions.assertEquals(expected, solution2030.smallestSubsequence(s, k, letter, repetition));
    }

    @Test
    public void example3() {
        String s = "bb";
        int k = 2;
        char letter = 'b';
        int repetition = 2;
        String expected = "bb";
        Assertions.assertEquals(expected, solution2030.smallestSubsequence(s, k, letter, repetition));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/389846254/
        // 删除字符数不足 n-k 个的场景
        String s = "aaabbbcccddd";
        int k = 3;
        char letter = 'b';
        int repetition = 2;
        String expected = "abb";
        Assertions.assertEquals(expected, solution2030.smallestSubsequence(s, k, letter, repetition));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/389847006/
        String s = "adffhjfmmmmorsfff";
        int k = 6;
        char letter = 'f';
        int repetition = 5;
        String expected = "afffff";
        Assertions.assertEquals(expected, solution2030.smallestSubsequence(s, k, letter, repetition));
    }

    @Test
    public void example6() {
        // https://leetcode.cn/submissions/detail/389850708/
        String s = "abbdglhoquvvwwyzz";
        int k = 15;
        char letter = 'l';
        int repetition = 1;
        String expected = "abbdglhoquvvwwy";
        Assertions.assertEquals(expected, solution2030.smallestSubsequence(s, k, letter, repetition));
    }
}

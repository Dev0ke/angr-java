import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution792Tests {
    private final Solution792 solution792 = new Solution792();

    @Test
    public void example1() {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        int expected = 3;
        Assertions.assertEquals(expected, solution792.numMatchingSubseq(s, words));
    }

    @Test
    public void example2() {
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        int expected = 2;
        Assertions.assertEquals(expected, solution792.numMatchingSubseq(s, words));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/382688964/
        // TLE
        String fileName = "solution792-example3-input.txt";
        String s = UtUtils.loadingString(fileName, 0);
        String[] words = UtUtils.loadingStrings(fileName, 1);
        int expected = 2500;
        Assertions.assertEquals(expected, solution792.numMatchingSubseq(s, words));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/447409143/
        // wa 57
        String fileName = "solution792-example4-input.txt";
        String s = UtUtils.loadingString(fileName, 0);
        String[] words = UtUtils.loadingStrings(fileName, 1);
        int expected = 52;
        Assertions.assertEquals(expected, solution792.numMatchingSubseq(s, words));
    }
}

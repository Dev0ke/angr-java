import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1202Tests {
    private final Solution1202 solution1202 = new Solution1202();

    @Test
    public void example1() {
        String s = "dcab";
        List<List<Integer>> pairs = UtUtils.stringToIntegerList2("[[0,3],[1,2]]");
        String expected = "bacd";
        Assertions.assertEquals(expected, solution1202.smallestStringWithSwaps(s, pairs));
    }

    @Test
    public void example2() {
        String s = "dcab";
        List<List<Integer>> pairs = UtUtils.stringToIntegerList2("[[0,3],[1,2],[0,2]]");
        String expected = "abcd";
        Assertions.assertEquals(expected, solution1202.smallestStringWithSwaps(s, pairs));
    }

    @Test
    public void example3() {
        String s = "cba";
        List<List<Integer>> pairs = UtUtils.stringToIntegerList2("[[0,1],[1,2]]");
        String expected = "abc";
        Assertions.assertEquals(expected, solution1202.smallestStringWithSwaps(s, pairs));
    }
}

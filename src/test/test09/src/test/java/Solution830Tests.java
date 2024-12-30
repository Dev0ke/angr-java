import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution830Tests {
    private final Solution830 solution830 = new Solution830();

    @Test
    public void example1() {
        String s = "abbxxxxzzy";
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[3,6]]");
        Assertions.assertEquals(expected, solution830.largeGroupPositions(s));
    }

    @Test
    public void example2() {
        String s = "abc";
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        Assertions.assertEquals(expected, solution830.largeGroupPositions(s));
    }

    @Test
    public void example3() {
        String s = "abcdddeeeeaabbbcd";
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[3,5],[6,9],[12,14]]");
        Assertions.assertEquals(expected, solution830.largeGroupPositions(s));
    }

    @Test
    public void example4() {
        String s = "aba";
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        Assertions.assertEquals(expected, solution830.largeGroupPositions(s));
    }
}

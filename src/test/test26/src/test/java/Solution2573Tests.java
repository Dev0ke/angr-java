import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2573Tests {
    private final Solution2573 solution2573 = new Solution2573();

    @Test
    public void example1() {
        int[][] lcp = UtUtils.stringToInts2("[[4,0,2,0],[0,3,0,1],[2,0,2,0],[0,1,0,1]]");
        String expected = "abab";
        Assertions.assertEquals(expected, solution2573.findTheString(lcp));
    }

    @Test
    public void example2() {
        int[][] lcp = UtUtils.stringToInts2("[[4,3,2,1],[3,3,2,1],[2,2,2,1],[1,1,1,1]]");
        String expected = "aaaa";
        Assertions.assertEquals(expected, solution2573.findTheString(lcp));
    }

    @Test
    public void example3() {
        int[][] lcp = UtUtils.stringToInts2("[[4,3,2,1],[3,3,2,1],[2,2,2,1],[1,1,1,3]]");
        String expected = "";
        Assertions.assertEquals(expected, solution2573.findTheString(lcp));
    }
}
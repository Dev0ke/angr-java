import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2076Tests {
    private final Solution2076 solution2076 = new Solution2076();

    @Test
    public void example1() {
        int n = 3;
        int[][] restrictions = UtUtils.stringToInts2("[[0,1]]");
        int[][] requests = UtUtils.stringToInts2("[[0,2],[2,1]]");
        boolean[] expected = {true, false};
        Assertions.assertArrayEquals(expected, solution2076.friendRequests(n, restrictions, requests));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] restrictions = UtUtils.stringToInts2("[[0,1]]");
        int[][] requests = UtUtils.stringToInts2("[[1,2],[0,2]]");
        boolean[] expected = {true, false};
        Assertions.assertArrayEquals(expected, solution2076.friendRequests(n, restrictions, requests));
    }

    @Test
    public void example3() {
        int n = 5;
        int[][] restrictions = UtUtils.stringToInts2("[[0,1],[1,2],[2,3]]");
        int[][] requests = UtUtils.stringToInts2("[[0,4],[1,2],[3,1],[3,4]]");
        boolean[] expected = {true, false, true, false};
        Assertions.assertArrayEquals(expected, solution2076.friendRequests(n, restrictions, requests));
    }
}

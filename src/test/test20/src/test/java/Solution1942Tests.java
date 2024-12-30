import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1942Tests {
    private final Solution1942 solution1942 = new Solution1942();

    @Test
    public void example1() {
        int[][] times = UtUtils.stringToInts2("[[1,4],[2,3],[4,6]]");
        int targetFriend = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1942.smallestChair(times, targetFriend));
    }

    @Test
    public void example2() {
        int[][] times = UtUtils.stringToInts2("[[3,10],[1,5],[2,6]]");
        int targetFriend = 0;
        int expected = 2;
        Assertions.assertEquals(expected, solution1942.smallestChair(times, targetFriend));
    }
}

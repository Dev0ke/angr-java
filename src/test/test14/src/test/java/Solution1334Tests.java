import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1334Tests {
    private final Solution1334 solution1334 = new Solution1334();

    @Test
    public void example1() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1,3],[1,2,1],[1,3,4],[2,3,1]]");
        int distanceThreshold = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution1334.findTheCity(n, edges, distanceThreshold));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]]");
        int distanceThreshold = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution1334.findTheCity(n, edges, distanceThreshold));
    }
}

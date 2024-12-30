import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution802Tests {
    private final Solution802 solution802 = new Solution802();

    @Test
    public void example1() {
        int[][] graph = UtUtils.stringToInts2("[[1,2],[2,3],[5],[0],[5],[],[]]");
        List<Integer> expected = List.of(2, 4, 5, 6);
        Assertions.assertEquals(expected, solution802.eventualSafeNodes(graph));
    }

    @Test
    public void example2() {
        int[][] graph = UtUtils.stringToInts2("[[1,2,3,4],[1,2],[3,4],[0,4],[]]");
        List<Integer> expected = List.of(4);
        Assertions.assertEquals(expected, solution802.eventualSafeNodes(graph));
    }
}

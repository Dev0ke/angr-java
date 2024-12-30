import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1606Tests {
    private final Solution1606 solution1606 = new Solution1606();

    @Test
    public void example1() {
        int k = 3;
        int[] arrival = {1, 2, 3, 4, 5};
        int[] load = {5, 2, 3, 3, 3};
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solution1606.busiestServers(k, arrival, load));
    }

    @Test
    public void example2() {
        int k = 3;
        int[] arrival = {1, 2, 3, 4};
        int[] load = {1, 2, 1, 2};
        List<Integer> expected = List.of(0);
        Assertions.assertEquals(expected, solution1606.busiestServers(k, arrival, load));
    }

    @Test
    public void example3() {
        int k = 3;
        int[] arrival = {1, 2, 3};
        int[] load = {10, 12, 11};
        List<Integer> expected = List.of(0, 1, 2);
        Assertions.assertEquals(expected, solution1606.busiestServers(k, arrival, load));
    }

    @Test
    public void example4() {
        int k = 3;
        int[] arrival = {1, 2, 3, 4, 8, 9, 10};
        int[] load = {5, 2, 10, 3, 1, 2, 2};
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solution1606.busiestServers(k, arrival, load));
    }

    @Test
    public void example5() {
        int k = 3;
        int[] arrival = {1};
        int[] load = {1};
        List<Integer> expected = List.of(0);
        Assertions.assertEquals(expected, solution1606.busiestServers(k, arrival, load));
    }
}

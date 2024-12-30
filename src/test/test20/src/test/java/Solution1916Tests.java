import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1916Tests {
    private final Solution1916 solution1916 = new Solution1916();

    @Test
    public void example1() {
        int[] prevRoom = {-1, 0, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution1916.waysToBuildRooms(prevRoom));
        Assertions.assertEquals(expected, solution1916.waysToBuildRooms2(prevRoom));
    }

    @Test
    public void example2() {
        int[] prevRoom = {-1, 0, 0, 1, 2};
        int expected = 6;
        Assertions.assertEquals(expected, solution1916.waysToBuildRooms(prevRoom));
        Assertions.assertEquals(expected, solution1916.waysToBuildRooms2(prevRoom));
    }
}

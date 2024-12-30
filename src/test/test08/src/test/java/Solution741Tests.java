import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution741Tests {
    private final Solution741 solution741 = new Solution741();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("""
                [[0, 1, -1],
                 [1, 0, -1],
                 [1, 1,  1]]
                """);
        int expected = 5;
        Assertions.assertEquals(expected, solution741.cherryPickup(grid));
    }
}

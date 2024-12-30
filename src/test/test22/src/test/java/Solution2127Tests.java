import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2127Tests {
    private final Solution2127 solution2127 = new Solution2127();

    @Test
    public void example1() {
        int[] favorite = {2, 2, 1, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution2127.maximumInvitations(favorite));
    }

    @Test
    public void example2() {
        int[] favorite = {1, 2, 0};
        int expected = 3;
        Assertions.assertEquals(expected, solution2127.maximumInvitations(favorite));
    }

    @Test
    public void example3() {
        int[] favorite = {3, 0, 1, 4, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution2127.maximumInvitations(favorite));
    }
}

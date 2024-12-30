import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2326Tests {
    private final Solution2326 solution2326 = new Solution2326();

    @Test
    public void example1() {
        int m = 3;
        int n = 5;
        ListNode head = ListNode.buildListNode(new int[]{3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0});
        int[][] expected = UtUtils.stringToInts2("[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]");
        Assertions.assertArrayEquals(expected, solution2326.spiralMatrix(m, n, head));
    }

    @Test
    public void example2() {
        int m = 1;
        int n = 4;
        ListNode head = ListNode.buildListNode(new int[]{0, 1, 2});
        int[][] expected = UtUtils.stringToInts2("[[0,1,2,-1]]");
        Assertions.assertArrayEquals(expected, solution2326.spiralMatrix(m, n, head));
    }
}

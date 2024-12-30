import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1315Tests {
    private final Solution1315 solution1315 = new Solution1315();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]");
        int expected = 18;
        Assertions.assertEquals(expected, solution1315.sumEvenGrandparent(root));
    }
}
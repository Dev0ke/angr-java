import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1302Tests {
    private final Solution1302 solution1302 = new Solution1302();

    @Test
    public void example1() {
        TreeNode treeNode = TreeNode.buildTreeNode("[1,2,3,4,5,null,6,7,null,null,null,null,8]");
        int expected = 15;
        Assertions.assertEquals(expected, solution1302.deepestLeavesSum(treeNode));
    }

    @Test
    public void example2() {
        TreeNode treeNode = TreeNode.buildTreeNode("[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]");
        int expected = 19;
        Assertions.assertEquals(expected, solution1302.deepestLeavesSum(treeNode));
    }
}

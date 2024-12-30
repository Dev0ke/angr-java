import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution437Tests {
    private final Solution437 solution437 = new Solution437();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[10,5,-3,3,2,null,11,3,-2,null,1]");
        int targetSum = 8;
        int expected = 3;
        Assertions.assertEquals(expected, solution437.pathSum(root, targetSum));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        int targetSum = 22;
        int expected = 3;
        Assertions.assertEquals(expected, solution437.pathSum(root, targetSum));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/340712419/
        // 爆 int
        TreeNode root = TreeNode.buildTreeNode("[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]");
        int targetSum = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution437.pathSum(root, targetSum));
    }
}

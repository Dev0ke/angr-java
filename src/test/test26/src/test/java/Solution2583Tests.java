import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2583Tests {
    private final Solution2583 solution2583 = new Solution2583();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,8,9,2,1,3,7,4,6]");
        int k = 2;
        long expected = 13;
        Assertions.assertEquals(expected, solution2583.kthLargestLevelSum(root, k));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,null,3]");
        int k = 1;
        long expected = 3;
        Assertions.assertEquals(expected, solution2583.kthLargestLevelSum(root, k));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/409146861/
        // 集合越界
        TreeNode root = TreeNode.buildTreeNode("[5,8,9,2,1,3,7]");
        int k = 4;
        long expected = -1;
        Assertions.assertEquals(expected, solution2583.kthLargestLevelSum(root, k));
    }
}

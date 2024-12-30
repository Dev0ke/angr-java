import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2385Tests {
    private final Solution2385 solution2385 = new Solution2385();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,5,3,null,4,10,6,9,2]");
        int start = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution2385.amountOfTime(root, start));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        int start = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution2385.amountOfTime(root, start));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/352928531/
        // NPE
        TreeNode root = TreeNode.buildTreeNode("[1,null,2,null,3,null,4,null,5]");
        int start = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution2385.amountOfTime(root, start));
    }
}

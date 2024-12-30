import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1161Tests {
    private final Solution1161 solution1161 = new Solution1161();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,7,0,7,-8,null,null]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1161.maxLevelSum(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[989,null,10250,98693,-89388,null,null,null,-32127]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1161.maxLevelSum(root));
    }
}

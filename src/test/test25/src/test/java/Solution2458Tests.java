import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2458Tests {
    private final Solution2458 solution2458 = new Solution2458();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,3,4,2,null,6,5,null,null,null,null,null,7]");
        int[] queries = {4};
        int[] expected = {2};
        Assertions.assertArrayEquals(expected, solution2458.treeQueries(root, queries));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,8,9,2,1,3,7,4,6]");
        int[] queries = {3, 2, 4, 8};
        int[] expected = {3, 2, 3, 2};
        Assertions.assertArrayEquals(expected, solution2458.treeQueries(root, queries));
    }
}

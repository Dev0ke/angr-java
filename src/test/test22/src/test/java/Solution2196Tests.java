import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2196Tests {
    private final Solution2196 solution2196 = new Solution2196();

    @Test
    public void example1() {
        int[][] descriptions = UtUtils.stringToInts2("[[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]");
        TreeNode expected = TreeNode.buildTreeNode("[50,20,80,15,17,19]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution2196.createBinaryTree(descriptions)));
    }

    @Test
    public void example2() {
        int[][] descriptions = UtUtils.stringToInts2("[[1,2,1],[2,3,0],[3,4,1]]");
        TreeNode expected = TreeNode.buildTreeNode("[1,2,null,null,3,4]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution2196.createBinaryTree(descriptions)));
    }
}

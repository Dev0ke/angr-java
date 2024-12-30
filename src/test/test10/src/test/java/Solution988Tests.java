import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution988Tests {
    private final Solution988 solution988 = new Solution988();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[0,1,2,3,4,3,4]");
        String expected = "dba";
        Assertions.assertEquals(expected, solution988.smallestFromLeaf(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[25,1,3,1,3,0,2]");
        String expected = "adz";
        Assertions.assertEquals(expected, solution988.smallestFromLeaf(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[2,2,1,null,1,0,null,0]");
        String expected = "abc";
        Assertions.assertEquals(expected, solution988.smallestFromLeaf(root));
    }
}
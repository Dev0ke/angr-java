import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution144Tests {
    private final Solution144 solution144 = new Solution144();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,null,2,3]");
        List<Integer> expected = List.of(1, 2, 3);
        Assertions.assertEquals(expected, solution144.preorderTraversal(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[]");
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution144.preorderTraversal(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solution144.preorderTraversal(root));
    }

    @Test
    public void example4() {
        TreeNode root = TreeNode.buildTreeNode("[1,2]");
        List<Integer> expected = List.of(1, 2);
        Assertions.assertEquals(expected, solution144.preorderTraversal(root));
    }

    @Test
    public void example5() {
        TreeNode root = TreeNode.buildTreeNode("[1,null,2]");
        List<Integer> expected = List.of(1, 2);
        Assertions.assertEquals(expected, solution144.preorderTraversal(root));
    }
}

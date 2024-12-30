import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution515Tests {
    private final Solution515 solution515 = new Solution515();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,3,2,5,3,null,9]");
        List<Integer> expected = List.of(1, 3, 9);
        Assertions.assertEquals(expected, solution515.largestValues(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3]");
        List<Integer> expected = List.of(1, 3);
        Assertions.assertEquals(expected, solution515.largestValues(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solution515.largestValues(root));
    }

    @Test
    public void example4() {
        TreeNode root = TreeNode.buildTreeNode("[1,null,2]");
        List<Integer> expected = List.of(1, 2);
        Assertions.assertEquals(expected, solution515.largestValues(root));
    }

    @Test
    public void example5() {
        TreeNode root = TreeNode.buildTreeNode("[]");
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution515.largestValues(root));
    }
}

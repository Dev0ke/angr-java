import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution199Tests {
    private final Solution199 solution199 = new Solution199();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,null,5,null,4]");
        List<Integer> expected = List.of(1, 3, 4);
        Assertions.assertEquals(expected, solution199.rightSideView(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,null,3]");
        List<Integer> expected = List.of(1, 3);
        Assertions.assertEquals(expected, solution199.rightSideView(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[]");
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution199.rightSideView(root));
    }
}

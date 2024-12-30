import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution257Tests {
    private final Solution257 solution257 = new Solution257();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,null,5]");
        List<String> expected = Arrays.asList("1->2->5", "1->3");
        List<String> actual = solution257.binaryTreePaths(root);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        List<String> expected = Arrays.asList("1");
        List<String> actual = solution257.binaryTreePaths(root);
        Assertions.assertEquals(expected, actual);
    }
}

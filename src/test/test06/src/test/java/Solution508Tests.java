import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution508Tests {
    private final Solution508 solution508 = new Solution508();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,2,-3]");
        int[] expected = {2, -3, 4};
        int[] actual = solution508.findFrequentTreeSum(root);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,2,-5]");
        int[] expected = {2};
        int[] actual = solution508.findFrequentTreeSum(root);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution863Tests {
    private final Solution863 solution863 = new Solution863();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode target = root.left;
        int k = 2;
        List<Integer> expected = new ArrayList<>(List.of(7, 4, 1));
        List<Integer> actual = solution863.distanceK(root, target, k);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        TreeNode target = root;
        int k = 3;
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = solution863.distanceK(root, target, k);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}

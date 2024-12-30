import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2096Tests {
    private final Solution2096 solution2096 = new Solution2096();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,1,2,3,null,6,4]");
        int startValue = 3;
        int destValue = 6;
        String expected = "UURL";
        Assertions.assertEquals(expected, solution2096.getDirections(root, startValue, destValue));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[2,1]");
        int startValue = 2;
        int destValue = 1;
        String expected = "L";
        Assertions.assertEquals(expected, solution2096.getDirections(root, startValue, destValue));
    }
}

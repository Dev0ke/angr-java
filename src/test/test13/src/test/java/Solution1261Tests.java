import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1261Tests {
    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[-1,null,-1]");
        Solution1261.FindElements findElements = new Solution1261.FindElements(root);
        // return False
        Assertions.assertFalse(findElements.find(1));
        // return True
        Assertions.assertTrue(findElements.find(2));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[-1,-1,-1,-1,-1]");
        Solution1261.FindElements findElements = new Solution1261.FindElements(root);
        // return True
        Assertions.assertTrue(findElements.find(1));
        // return True
        Assertions.assertTrue(findElements.find(3));
        // return False
        Assertions.assertFalse(findElements.find(5));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[-1,null,-1,-1,null,-1]");
        Solution1261.FindElements findElements = new Solution1261.FindElements(root);
        // return True
        Assertions.assertTrue(findElements.find(2));
        // return False
        Assertions.assertFalse(findElements.find(3));
        // return False
        Assertions.assertFalse(findElements.find(4));
        // return True
        Assertions.assertTrue(findElements.find(5));
    }
}